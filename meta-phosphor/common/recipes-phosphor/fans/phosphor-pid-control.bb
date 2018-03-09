HOMEPAGE = "github.com/openbmc/phosphor-pid-control"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dc7f21ccff0f672f2a7cd6f412ae627d"

SUMMARY = "Phosphor PID Fan Control"
DESCRIPTION = "Fan Control"
PR = "r1"

SRC_URI = "git://github.com/openbmc/phosphor-pid-control"
SRCREV = "7494ce0bdd5f707b8e07d907e2202df0f3426da0"
S = "${WORKDIR}/git"

inherit autotools pkgconfig
inherit pythonnative

inherit phosphor-pid-control
inherit obmc-phosphor-ipmiprovider-symlink

# Each platform will need a service file that starts
# at an appropriate time per system.  For instance, if
# your system relies on passive dbus for fans or other
# sensors then it may be prudent to wait for all of them.

DEPENDS += "autoconf-archive-native"
DEPENDS += "python-pyyaml-native"
DEPENDS += "python-mako-native"
DEPENDS += "sdbusplus"
DEPENDS += "phosphor-logging"
DEPENDS += "libevdev"
DEPENDS += "libconfig"

# We depend on someone providing their system's configuration.
DEPENDS += "virtual/phosphor-fans-sensor-inventory"
# We depend on this to be built first so we can build our providers.
DEPENDS += "phosphor-ipmi-host"

RDEPENDS_${PN} += "sdbusplus phosphor-dbus-interfaces"

FILES_${PN} = "${sbindir}/swampd ${sbindir}/setsensor"
FILES_${PN}_append = " ${libdir}/ipmid-providers/lib*${SOLIBS}"
FILES_${PN}_append = " ${libdir}/host-ipmid/lib*${SOLIBS}"
FILES_${PN}_append = " ${libdir}/net-ipmid/lib*${SOLIBS}"
FILES_${PN}-dev_append = " ${libdir}/ipmid-providers/lib*${SOLIBSDEV} ${libdir}/ipmid-providers/*.la"

EXTRA_OECONF = "SENSOR_YAML_GEN=${STAGING_DIR_NATIVE}${sensor_datadir}/sensor-list.yaml \
                PID_YAML_GEN=${STAGING_DIR_NATIVE}${sensor_datadir}/pid-list.yaml"

HOSTIPMI_PROVIDER_LIBRARY += "libmanualcmds.so"

# Install the tuning test script
RDEPEND_${PN} += " bash"
SRC_URI_append = " file://fan_rpm_loop_test.sh"
FILES_${PN}_append = " ${sbindir}/fan_rpm_loop_test.sh"

do_install_append() {
    install -d ${D}/usr/sbin
    install -Dm 0755 ${WORKDIR}/fan_rpm_loop_test.sh ${D}/${sbindir}/fan_rpm_loop_test.sh
}
