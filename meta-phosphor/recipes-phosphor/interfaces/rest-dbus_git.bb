SUMMARY = "Phosphor OpenBMC REST framework"
DESCRIPTION = "Phosphor OpenBMC REST to DBUS daemon."
HOMEPAGE = "http://github.com/openbmc/rest-dbus"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e"
SRCREV = "99d57f2698568be1bf989057f678ff5c053e7957"
PV = "1.0+git${SRCPV}"
PR = "r1"

SRC_URI += "git://github.com/openbmc/rest-dbus.git;branch=master;protocol=https"

SYSTEMD_SERVICE:${PN} += "rest-dbus.service rest-dbus.socket"
S = "${WORKDIR}/git"

inherit allarch
inherit obmc-phosphor-systemd
inherit setuptools3

RDEPENDS:${PN} += " \
        python-netserver \
        python-json \
        python-dbus \
        python-xml \
        pyphosphor-dbus \
        "
