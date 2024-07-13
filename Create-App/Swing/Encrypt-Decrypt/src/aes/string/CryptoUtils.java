/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aes.string;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 * A utility class that encrypts or decrypts a file.
 *
 * @author www.codejava.net
 *
 */
public class CryptoUtils {

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";

    public static String encrypt(String key, String inputData)
            throws CryptoException {
        return doCrypto(Cipher.ENCRYPT_MODE, key, inputData);
    }

    public static String decrypt(String key, String inputData)
            throws CryptoException {
        return doCrypto(Cipher.DECRYPT_MODE, key, inputData);
    }

    private static String doCrypto(int cipherMode, String key, String inputData) throws CryptoException {
        try {
            Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(cipherMode, secretKey);

            byte[] inputBytes = cipherMode == Cipher.DECRYPT_MODE
                    ? Base64.getDecoder().decode(inputData.getBytes("UTF-8"))
                    : inputData.getBytes("UTF-8");
            System.out.println("Truoc inputBytes " + inputBytes.toString());
            byte[] outputBytes = cipher.doFinal(inputBytes);
            System.out.println("Sau inputBytes " + outputBytes.toString());

            // Convert byte array back to string after encryption/decryption
            // String result = new String(outputBytes);
            return new String(outputBytes);
        } catch (NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidKeyException | BadPaddingException
                | IllegalBlockSizeException | UnsupportedEncodingException ex) {
            throw new CryptoException("Error encrypting/decrypting the input data", ex);
        }
    }
}
