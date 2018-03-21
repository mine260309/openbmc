FILESEXTRAPATHS_prepend_quanta-q71l := "${THISDIR}/${PN}:"
inherit obmc-phosphor-systemd
SRC_URI_append_quanta-q71l = " file://phosphosr-pid-control.service "
SYSTEMD_SERVICE_${PN}_append_quanta-q71l = " phosphor-pid-control.service"
