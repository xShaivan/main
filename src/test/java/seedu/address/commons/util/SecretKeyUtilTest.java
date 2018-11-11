package seedu.address.commons.util;

import java.io.FileNotFoundException;

import javax.crypto.SecretKey;

import org.junit.Test;

import seedu.address.testutil.Assert;

public class SecretKeyUtilTest {
    private SecretKey secretKey = SecretKeyUtil.getSecretKey("AES");

    @Test
    public void parseInvalidAlgorithmThrowsNullPointerException() {
        Assert.assertThrows(NullPointerException.class, () -> SecretKeyUtil.getSecretKey("MY ALGORITHM"));
    }

    @Test
    public void parseInvalidFileNameSaveSecretKeyThrowsFileNotFoundException() {
        Assert.assertThrows(FileNotFoundException.class, () -> SecretKeyUtil.saveSecretKey(secretKey, "///"));
    }
}
