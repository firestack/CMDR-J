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

    packages.cmdr-j = pkgs.callPackage ./default.nix {};
    packages.cmdr-j-standalone = pkgs.callPackage ./graalvm.nix {
      inherit (self.packages.${system}) cmdr-j;
    };

    defaultPackage = self.packages.${system}.cmdr-j;

  });
}
