{
	description = "Build a cargo project";

	inputs = {
		nixpkgs.url = "github:NixOS/nixpkgs/nixpkgs-unstable";

		crane = {
			url = "github:ipetkov/crane";
			inputs.nixpkgs.follows = "nixpkgs";
		};

		flake-utils.url = "github:numtide/flake-utils";

		rust-overlay = {
			url = "github:oxalica/rust-overlay";
			inputs = {
				nixpkgs.follows = "nixpkgs";
				flake-utils.follows = "flake-utils";
			};
		};
	};

	outputs = { self, nixpkgs, crane, flake-utils, rust-overlay, ... }:
		flake-utils.lib.eachDefaultSystem (system:
			let
				pkgs = import nixpkgs {
					inherit system;
					overlays = [ (import rust-overlay) ];
				};

				inherit (pkgs) lib;

				rustToolchain = pkgs.rust-bin.nightly.latest.default.override {
					# Set the build targets supported by the toolchain,
					# wasm32-unknown-unknown is required for trunk
					targets = [ "wasm32-unknown-unknown" ];
				};
				craneLib = (crane.mkLib pkgs).overrideToolchain rustToolchain;

				# When filtering sources, we want to allow assets other than .rs files
				src = lib.cleanSourceWith {
					src = ./.; # The original, unfiltered source
					filter = path: type:
						(lib.hasSuffix "\.html" path) ||
						(lib.hasSuffix "\.scss" path) ||
						# Example of a folder for images, icons, etc
						(lib.hasInfix "/assets/" path) ||
						# Default filter from crane (allow .rs files)
						(craneLib.filterCargoSources path type)
					;
				};

				# Common arguments can be set here to avoid repeating them later
				commonArgs = {
					inherit src;
					# We must force the target, otherwise cargo will attempt to use your native target
					CARGO_BUILD_TARGET = "wasm32-unknown-unknown";
				};

				# Build *just* the cargo dependencies, so we can reuse
				# all of that work (e.g. via cachix) when running in CI
				cargoArtifacts = craneLib.buildDepsOnly (commonArgs // {
					# You cannot run cargo test on a wasm build
					doCheck = false;
				});

				buildLeptosPackage = {
					cargoArtifacts,
					cargoLeptosExtraArgs ? "", # Arguments that are generally useful default
					cargoExtraArgs ? "", # Other cargo-general flags (e.g. for features or targets)
					...
				}@origArgs: let
					# Clean the original arguments for good hygiene (i.e. so the flags specific
					# to this helper don't pollute the environment variables of the derivation)
					args = builtins.removeAttrs origArgs [
						"cargoLeptosExtraArgs"
						"cargoExtraArgs"
					];
				in craneLib.mkCargoDerivation (args // {
					# Additional overrides we want to explicitly set in this helper

					# Require the caller to specify cargoArtifacts we can use
					inherit cargoArtifacts;

					# A suffix name used by the derivation, useful for logging
					pnameSuffix = "-leptos-build";

					# Set the cargo command we will use and pass through the flags
					buildPhaseCargoCommand = "cargo leptos build ${cargoExtraArgs} ${cargoLeptosExtraArgs}";

					# Append the `cargo-awesome` package to the nativeBuildInputs set by the
					# caller (or default to an empty list if none were set)
					nativeBuildInputs = (args.nativeBuildInputs or [ ]) ++ [ self.packages.${system}.cargo-leptos ];
				});

				# Build the actual crate itself, reusing the dependency
				# artifacts from above.
				# This derivation is a directory you can put on a webserver.
				cmdr-rs-trunk = craneLib.buildTrunkPackage (commonArgs // {
					inherit cargoArtifacts;
				});

				cmdr-rs-server = buildLeptosPackage (commonArgs // {
					inherit cargoArtifacts;
				});

				cmdr-rs = cmdr-rs-server;

				# Quick example on how to serve the app,
				# This is just an example, not useful for production environments
				serve-app = pkgs.writeShellScriptBin "serve-app" ''
					${pkgs.python3Minimal}/bin/python3 -m http.server --directory ${cmdr-rs} 8000
				'';
			in
			rec {
				checks = {
					# Build the crate as part of `nix flake check` for convenience
					inherit cmdr-rs;

					# Run clippy (and deny all warnings) on the crate source,
					# again, reusing the dependency artifacts from above.
					#
					# Note that this is done as a separate derivation so that
					# we can block the CI if there are issues here, but not
					# prevent downstream consumers from building our crate by itself.
					cmdr-rs-clippy = craneLib.cargoClippy (commonArgs // {
						inherit cargoArtifacts;
						cargoClippyExtraArgs = "--all-targets -- --deny warnings";
					});

					# Check formatting
					cmdr-rs-fmt = craneLib.cargoFmt {
						inherit src;
					};
				};

				packages.default = cmdr-rs;
				packages.cmdr-rs = cmdr-rs;

				packages.cargo-leptos = pkgs.callPackage ./cargo-leptos.nix {};

				apps.default = flake-utils.lib.mkApp {
					drv = serve-app;
				};

				devShells.default = pkgs.mkShell {
					inputsFrom = builtins.attrValues self.checks;

					# Extra inputs can be added here
					nativeBuildInputs = [
						# cargo
						# rustc
						rustToolchain

						pkgs.pkg-config
						pkgs.openssl
						pkgs.dart-sass


						pkgs.cargo-generate
						packages.cargo-leptos
						pkgs.trunk
					];
				};
			});
}
