FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://state_hook"

do_install:append() {
    install -d ${D}${sysconfdir}/nbd-proxy/
    install -m 0755 ${WORKDIR}/state_hook ${D}${sysconfdir}/nbd-proxy/state
}

FILES:${PN} += "${sysconfdir}/nbd-proxy/state"
