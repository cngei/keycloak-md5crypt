package it.cngei.keycloak.md5crypt;

import org.keycloak.Config;
import org.keycloak.credential.hash.PasswordHashProvider;
import org.keycloak.credential.hash.PasswordHashProviderFactory;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;

public class Md5CryptPasswordHashProviderFactory implements PasswordHashProviderFactory {
    public static final String ID = "md5crypt";

    @Override
    public PasswordHashProvider create(KeycloakSession session) {
        return new Md5CryptPasswordHashProvider(ID);
    }

    @Override
    public void init(Config.Scope config) {
    }

    @Override
    public void postInit(KeycloakSessionFactory factory) {
    }

    @Override
    public String getId() {
        return ID;
    }

    @Override
    public void close() {
    }
}
