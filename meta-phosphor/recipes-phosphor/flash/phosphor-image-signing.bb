SUMMARY = "OpenBMC image signing public key"
DESCRIPTION = "Public key information to be included in images for image verification."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"
DEPENDS += "openssl-native"
DEPENDS += "${@oe.utils.conditional('INSECURE_KEY', 'True', 'phosphor-insecure-signing-key-native', '', d)}"
PR = "r1"

SIGNING_KEY ?= "${STAGING_DIR_NATIVE}${datadir}/OpenBMC.priv"
SIGNING_KEY_TYPE = "${@os.path.splitext(os.path.basename('${SIGNING_KEY}'))[0]}"
SYSROOT_DIRS:append = " ${sysconfdir}"

inherit allarch

do_install() {
        openssl pkey -in "${SIGNING_KEY}" -pubout -out ${WORKDIR}/publickey
        echo HashType=RSA-SHA256 > "${WORKDIR}/hashfunc"
        idir="${D}${sysconfdir}/activationdata/${SIGNING_KEY_TYPE}"
        install -d ${idir}
        install -m 644 ${WORKDIR}/publickey ${idir}
        install -m 644 ${WORKDIR}/hashfunc ${idir}
}

FILES:${PN} += "${sysconfdir}/activationdata/"

INSECURE_KEY = "${@'${SIGNING_KEY}' == '${STAGING_DIR_NATIVE}${datadir}/OpenBMC.priv'}"
