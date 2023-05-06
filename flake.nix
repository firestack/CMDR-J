{
	description = "CMDR-Js";
	inputs.utils.url = "github:numtide/flake-utils";

	outputs = { self, nixpkgs, utils }: {} // utils.lib.eachSystem ["x86_64-linux"] (system: let
	 pkgs = import nixpkgs { inherit system;
		overlays = [(final: prev: {
			buildGradle = final.callPackage ./gradle-env.nix {};
		})];
		};
	in {

		packages = rec {
			cmdr-j = pkgs.callPackage ./default.nix {};
			cmdr-j-standalone = pkgs.callPackage ./graalvm.nix {
				inherit (self.packages.${system}) cmdr-j;
			};
			default = cmdr-j-nixpkgs-standalone;
		};
		cmdr-j-nixpkgs-standalone = pkgs.buildGraalvmNativeImage {
			pname = "CommanderJ";
			version = "0.1.0";
			jar = cmdr-j;
		};
	});
}
