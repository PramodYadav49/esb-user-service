package com.example.user_app.service;

import com.example.user_app.entity.User;
import jakarta.ws.rs.core.Response;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class KeycloakUserService {

    private final Keycloak keycloak;
    private final String targetRealm;

    public KeycloakUserService(Keycloak keycloak, @Value("${keycloak.target-realm}") String targetRealm) {
        this.keycloak = keycloak;
        this.targetRealm = targetRealm;
    }

    public String createUser(User clUser) {

        UserRepresentation user = new UserRepresentation();
        user.setEnabled(true);
        user.setUsername(clUser.getUsername());
        user.setEmail(clUser.getEmail());
        user.setFirstName(clUser.getFirstName());
        user.setLastName(clUser.getLastName());

        CredentialRepresentation credential =
                new CredentialRepresentation();
        credential.setType(CredentialRepresentation.PASSWORD);
        credential.setValue(clUser.getPassword());
        credential.setTemporary(false);

        user.setCredentials(
                Collections.singletonList(credential));

        Response response = keycloak
                .realm(targetRealm)
                .users()
                .create(user);

        return "Status : " + response.getStatus();
    }
}
