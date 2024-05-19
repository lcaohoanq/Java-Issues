package aes.string;

import java.io.File;

public class CryptoUtilsTest {

    public static void main(String[] args) {
        String key = "Mary has one cat"; // 16bytes

        // AES only supports key sizes of 16, 24 or 32 bytes.
        // You either need to provide exactly that amount or you derive the key from
        // what you type in.
        String str = "1234567891111111";
        System.out.println("Before encrypt: " + str);

        try {
            
            String encrypted = CryptoUtils.encrypt(key, str);
            System.out.println("Encrypt data: " + encrypted);

//            String decrypted = CryptoUtils.decrypt(key, encrypted);
//            System.out.println("Decrypt data: " + decrypted);
        } catch (CryptoException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

}
