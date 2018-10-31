package seedu.address.commons.util;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class SecretKeyUtil {
    public static SecretKey getSecretKey(String algorithm) {
        KeyGenerator keyGenerator = null;

        try {
            keyGenerator = KeyGenerator.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return keyGenerator.generateKey();
    }

    public static String keyToString(SecretKey secretKey) {
        byte encoded[] = secretKey.getEncoded();

        String encodeToString = Base64.getEncoder().encodeToString(encoded);

        return encodeToString;
    }
}
