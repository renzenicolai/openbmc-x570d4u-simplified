# This is a packagegroup in name and principle but we do not want to inherit
# from packagegroup.bbclass.  The point of this packagegroup is to get the
# sysroot populated with YAML files from the DEPENDS packages and if we inherit
# the packagegroup bbclass this doesn't happen, because that bbclass `deltask`
# a number that are required.
# inherit packagegroup
SUMMARY = "Phosphor OpenBMC - YAML Providers"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"
DEPENDS = "${OBMC_YAML_PROVIDER_RECIPES}"
PR = "r1"

RDEPENDS:${PN} = "${OBMC_YAML_PROVIDER_RECIPES}"

OBMC_YAML_PROVIDER_RECIPES += " \
    phosphor-led-manager-yaml-provider \
    phosphor-software-manager-yaml-provider \
    "
