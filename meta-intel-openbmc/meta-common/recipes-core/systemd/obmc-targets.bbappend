# Remove these files since they are provided by obmc-intel-targets
SYSTEMD_SERVICE:${PN}:remove:intel = " obmc-host-start@.target"
SYSTEMD_SERVICE:${PN}:remove:intel = " obmc-host-stop@.target"
SYSTEMD_SERVICE:${PN}:remove:intel = " obmc-host-reboot@.target"
SYSTEMD_SERVICE:${PN}:remove:intel = " obmc-host-startmin@.target"
SYSTEMD_SERVICE:${PN}:remove:intel = " obmc-chassis-poweron@.target"
SYSTEMD_SERVICE:${PN}:remove:intel = " obmc-chassis-poweroff@.target"
SYSTEMD_SERVICE:${PN}:remove:intel = " obmc-chassis-hard-poweroff@.target"
SYSTEMD_SERVICE:${PN}:remove:intel = " obmc-chassis-powerreset@.target"
