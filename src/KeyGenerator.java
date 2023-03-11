import java.security.SecureRandom;
import java.util.Base64;

    public class KeyGenerator {
        public void getKeyGenerator() {
            SecureRandom secureRandom = new SecureRandom();
            byte[] keyBytes = new byte[16];
            secureRandom.nextBytes(keyBytes);
            String keyBase64 = Base64.getEncoder().encodeToString(keyBytes);
            System.out.println("Generated encryption key: " + keyBase64);
        }
    }