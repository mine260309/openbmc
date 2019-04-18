SYSTEMD_SERVICE_${PN}_remove += " \
    obmc-fans-ready.target \
    obmc-fan-control.target \
    obmc-fan-control-ready@.target \
    obmc-fan-watchdog-takeover.target \
    "
