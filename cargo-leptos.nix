{ lib
, rustPlatform
, fetchCrate
, pkg-config
, openssl
}:

rustPlatform.buildRustPackage rec {
	pname = "cargo-leptos";
	version = "0.1.8";

	src = fetchCrate {
		inherit pname version;
		sha256 = "sha256-E7ZSe15X2qZbyAKEO90xx7HpAymGiBTC9G3DZJ3JerU=";
	};

	cargoSha256 = "sha256-w/9W4DXbh4G5DZ8IGUz4nN3LEjHhL7HgybHqODMFzHw=";

	doCheck = false;

	nativeBuildInputs = [ pkg-config ];
	buildInputs = [ openssl ];
}
