RDEPENDS_${PN}-inventory += " openpower-occ-control phosphor-cooling-type id-button"
RDEPENDS_${PN}-extras += " phosphor-webui phosphor-image-signing obmc-ikvm "
RDEPENDS_${PN}-extras += " bmcweb"

RDEPENDS_${PN}-extras_remove += "nginx"

RDEPENDS_${PN}-fans_remove += "obmc-control-fan"
RDEPENDS_${PN}-chassis_remove += "obmc-button-reset"

#RDEPENDS_${PN}-logging_remove += "ibm-logging"
#
RDEPENDS_${PN}-extras_remove = " \
       phosphor-rest \
       phosphor-gevent \
       "
