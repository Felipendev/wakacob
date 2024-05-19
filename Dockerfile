FROM ubuntu:latest
LABEL authors="til_fpedroso"

ENTRYPOINT ["top", "-b"]