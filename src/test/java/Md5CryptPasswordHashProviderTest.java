import it.cngei.keycloak.md5crypt.Md5CryptPasswordHashProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.keycloak.models.credential.PasswordCredentialModel;

import java.util.ArrayList;

public class Md5CryptPasswordHashProviderTest {
    private final Md5CryptPasswordHashProvider hashProvider = new Md5CryptPasswordHashProvider("CNGEI");

    private PasswordCredentialModel getCredentialsForHash(String hash) {
        return PasswordCredentialModel.createFromValues("md5crypt", new byte[0], 10, hash);
    }

    @Test
    public void testPasswordMatchFail() {
        Assertions.assertFalse(hashProvider.verify("ciao1234", getCredentialsForHash("$1$5RQctmde$hcf/tTMIBEfNdGCyom1PI.")));
    }

    @Test
    public void testPasswordMatch() {
        Assertions.assertTrue(hashProvider.verify("cacca1234", getCredentialsForHash("107ffa0eb5aab6908e48387f716710e9")));
    }

    @Test
    public void testLegacyPasswordMatchFail() {
        Assertions.assertFalse(hashProvider.verify("ciao1234", getCredentialsForHash("107ffa0eb5aab6908e48387f716710e9")));
    }

    @Test
    public void testLegacyPasswordMatch() {
        Assertions.assertTrue(hashProvider.verify("cacca1234", getCredentialsForHash("$1$5RQctmde$hcf/tTMIBEfNdGCyom1PI.")));
    }

    @Test
    public void testEncodePassword() {
        var encoded = hashProvider.encode("cacca1234", 0);
        Assertions.assertTrue(hashProvider.verify("cacca1234", getCredentialsForHash(encoded)));
    }
}