create keycloak on docker command
--docker run -d --name keycloak-server -p 8180:8080 -e KC_DB=postgres -e KC_DB_URL=jdbc:postgresql://host.docker.internal:5432/keycloak -e KC_DB_USERNAME=postgres -e KC_DB_PASSWORD=bitsflowtech -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:24.0 start-dev
