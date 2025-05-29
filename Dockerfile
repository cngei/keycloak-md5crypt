FROM quay.io/keycloak/keycloak:26.2.2

COPY ./keycloak-md5crypt-1.0.1.jar /opt/keycloak/providers/
COPY ./theme.jar /opt/keycloak/providers/
