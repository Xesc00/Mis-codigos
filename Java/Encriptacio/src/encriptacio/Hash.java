
package encriptacio;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Hash {

    public static SecretKey passwordKeyGeneration(String text, int keySize) {
        SecretKey sKey = null;
        if ((keySize == 128) || (keySize == 192) || (keySize == 256)) {
            try {
                byte[] data = text.getBytes("UTF-8");
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] hash = md.digest(data);
                byte[] key = Arrays.copyOf(hash, keySize / 8);
                sKey = new SecretKeySpec(key, "AES");
            } catch (Exception ex) {
                System.err.println("Error generant la clau:" + ex);
            }
        }
        return sKey;
    }
    
        public static boolean compareHash(SecretKey hashclient, SecretKey hashserver) {

        if (new String(hashclient.getEncoded(), StandardCharsets.UTF_8).equals(new String(hashserver.getEncoded(), StandardCharsets.UTF_8))) {
            System.out.println("CORRECT hash, the message has not been modified");
            return true;
        } else {
            System.out.println("FALSE hash, the message has been modified");
            return false;
        }
    }
    
}
