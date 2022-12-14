DEFAULTTUNE ?= "arm7a-novfp"

require conf/machine/include/arm/arch-armv7a.inc

TUNEVALID[arm7a-novfp] = "Enable arm7a-novfp specific processor optimizations"

AVAILTUNES += "arm7a-novfp"
ARMPKGARCH:tune-arm7a-novfp = "armv7a"
TUNE_FEATURES:tune-armv7a = "arm armv7a"
TUNE_FEATURES:tune-arm7a-novfp = "${TUNE_FEATURES:tune-armv7a} arm7a-novfp"
PACKAGE_EXTRA_ARCHS:tune-arm7a-novfp = "${PACKAGE_EXTRA_ARCHS:tune-armv7a}"
