package com.insider.travel.japan.wabisabi.serverlib.utils.common;

import org.apache.commons.lang3.StringUtils;
import org.owasp.esapi.errors.EncryptionException;
import org.owasp.esapi.reference.crypto.JavaEncryptor;

/**
 *
 * 
 */
public class PasswordUtil {

    private static int ITERATION_COUNT = 10000;
    private static String SECRET_SPICE = "B8124855403529E66C321DDBFC7E003641";

    public static String getPasswordHash(String password, String salt) throws EncryptionException {
        return createHash(password, salt);
    }

    public static String getAccountPasswordHash(String password, String salt) throws EncryptionException {
        return createHash(password, StringUtils.lowerCase(salt));
    }

    private static String createHash(String str, String salt) throws EncryptionException {
        JavaEncryptor enc = (JavaEncryptor) JavaEncryptor.getInstance();

        return enc.hash(str, enc.hash(salt, SECRET_SPICE), ITERATION_COUNT);
    }

}
