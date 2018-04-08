FROM openjdk:8u151-jdk-alpine3.7

ARG VERSION


ADD orchestrate-$VERSION.tar /tmp
RUN mv /tmp/orchestrate-$VERSION /orchestrate

VOLUME /var/lib/orchestrate
VOLUME /etc/orchestrate

ENV ORCHESTRATE_CONFIG /etc/orchestrate
ENV ORCHESTRATE_DATA /var/lib/orchestrate

WORKDIR /var/lib/orchestrate

ENTRYPOINT ["sh", "/orchestrate/bin/orchestrate"]