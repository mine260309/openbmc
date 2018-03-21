FILESEXTRAPATHS_prepend_romulus := "${THISDIR}/${PN}:"
inherit obmc-phosphor-systemd
SRC_URI_append_romulus = " file://phosphor-pid-control.service "
SYSTEMD_SERVICE_${PN}_append_romulus = " phosphor-pid-control.service"
