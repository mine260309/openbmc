RDEPENDS_${PN}-inventory += "openpower-fru-vpd openpower-occ-control virtual/obmc-gpio-presence"
RDEPENDS_${PN}-extras += "witherspoon-pfault-analysis witherspoon-power-supply-sync phosphor-webui"

${PN}-software-extras_df-obmc-ubi-fs += "phosphor-software-manager-sync"

# Remove fan control and presence
RDEPENDS_${PN}-fan-control = ""
RDEPENDS_${PN}-inventory_remove += "${VIRTUAL-RUNTIME_obmc-fan-presence}"
