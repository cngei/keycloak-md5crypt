package it.cngei.keycloak.md5crypt;

import org.keycloak.credential.hash.PasswordHashProvider;
import org.keycloak.models.PasswordPolicy;
import org.keycloak.models.credential.PasswordCredentialModel;
import org.apache.commons.codec.digest.Md5Crypt;

public class Md5CryptPasswordHashProvider implements PasswordHashProvider {
    private final String providerId;

    public Md5CryptPasswordHashProvider(String providerId) {
        this.providerId = providerId;
    }

    @Override
    public boolean policyCheck(PasswordPolicy policy, PasswordCredentialModel credential) {
        return providerId.equals(credential.getPasswordCredentialData().getAlgorithm());
    }

    @Override
    public PasswordCredentialModel encodedCredential(String rawPassword, int iterations) {
        String encodedPassword = encode(rawPassword, iterations);

        // bcrypt salt is stored as part of the encoded password so no need to store salt separately
        return PasswordCredentialModel.createFromValues(providerId, new byte[0], iterations, encodedPassword);
    }

    @Override
    public String encode(String rawPassword, int iterations) {
        return Md5Crypt.md5Crypt(rawPassword.getBytes());
    }

    @Override
    public void close() {

    }

    public boolean verifyString(String rawPassword, String rawHash) {
        String computedHash = Md5Crypt.md5Crypt(rawPassword.getBytes(), rawHash);
        return rawHash.equals(computedHash);
    }

    @Override
    public boolean verify(String rawPassword, PasswordCredentialModel credential) {
        final String hash = credential.getPasswordSecretData().getValue();
        return verifyString(rawPassword, hash);
    }
}
