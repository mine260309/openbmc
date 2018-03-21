SUMMARY = "Quanta Q71l Fans to PIDS Sensor mapping."
PR = "r1"

inherit native
inherit phosphor-pid-control
inherit obmc-phosphor-license

PROVIDES += "virtual/phosphor-fans-sensor-inventory"

SRC_URI += "file://sensor-list.yaml file://pid-list.yaml"

S = "${WORKDIR}"

do_install() {
    DEST=${D}${sensor_datadir}
    install -d ${DEST}
    install sensor-list.yaml ${DEST}/sensor-list.yaml
    install pid-list.yaml ${DEST}/pid-list.yaml
}
