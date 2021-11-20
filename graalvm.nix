{ lib
, cmdr-j
, graalvm11
}: (cmdr-j.override { 
   gradleFlags = [ "standaloneJar" ];

}).overrideAttrs (args: args//{
   buildInputs = [ graalvm11 ];
   buildJdk = graalvm11;

   postBuild = ''
      ${graalvm11}/bin/native-image -jar ./build/libs/CommanderJ.jar
   '';

   installPhase = ''
      mkdir -p $out/bin;
      cp CommanderJ $out/bin/
   '';
})