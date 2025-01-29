package encriptacio;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;

public class RSA_Asimetric {
    
    public static KeyPair randomGenerate(int len) {
    KeyPair keys = null;
    try {
        KeyPairGenerator keyGen = KeyPairGenerator .getInstance("RSA");
        keyGen.initialize(len);
        keys = keyGen.genKeyPair();
    } catch (NoSuchAlgorithmException ex) {
        System.err.println("Generador no disponible.");
    }
    return keys;
    }

    public static byte[] encryptData(byte[] data, PublicKey pub) {
        byte[] encryptedData = null;
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", "SunJCE");
            cipher.init(Cipher.ENCRYPT_MODE, pub);
            encryptedData = cipher.doFinal(data);
        } catch (Exception ex) {
            System.err.println("Error xifrant: " + ex);
        }
        return encryptedData;
    }

    public static byte[] decryptData(byte[] dataEncrypted, PrivateKey priv) {
        byte[] Data = null;
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", "SunJCE");
            cipher.init(Cipher.DECRYPT_MODE, priv);
            Data = cipher.doFinal(dataEncrypted);
        } catch (Exception ex) {
            System.err.println("Error xifrant: " + ex);
        }
        return Data;
    }
    
}
