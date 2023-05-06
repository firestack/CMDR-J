{ lib

, buildGradle

, jdk11
, gradle_6

, inShell ? false
, gradleFlags ? [ "installDist" ]
}: buildGradle {
   pname = "CMDR-J";
   version = "0.1.0";

   envSpec = ./gradle-env.json;
   src = builtins.path { path = ./.; name = "CMDR-J"; };

   buildInputs = [ jdk11 ];
   buildJdk = jdk11;
   gradleFlags = [ "-Dfile.encoding=utf-8" ] ++ gradleFlags;

   doCheck = false;

   installPhase = ''
      mkdir -p $out
      cp -r ./build/install/CommanderJ/* $out/
   '';

   NIX_DEBUG=5;

	meta.mainProgram = "CommanderJ";
}
