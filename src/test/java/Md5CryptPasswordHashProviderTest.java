import it.cngei.keycloak.md5crypt.Md5CryptPasswordHashProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Md5CryptPasswordHashProviderTest {
    private final Md5CryptPasswordHashProvider hashProvider = new Md5CryptPasswordHashProvider("CNGEI");

    @Test
    public void testPasswordMatchFail() {
        Assertions.assertFalse(hashProvider.verifyString("ciao1234", "$1$5RQctmde$hcf/tTMIBEfNdGCyom1PI."));
    }

    @Test
    public void testPasswordMatch() {
        Assertions.assertTrue(hashProvider.verifyString("cacca1234", "$1$5RQctmde$hcf/tTMIBEfNdGCyom1PI."));
    }

    @Test
    public void testEncodePassword() {
        var encoded = hashProvider.encode("cacca1234", 0);
        Assertions.assertTrue(hashProvider.verifyString("cacca1234", encoded));
    }
}