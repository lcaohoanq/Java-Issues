package aes.file;

import java.io.File;

public class CryptoUtilsTest {

    public static void main(String[] args) {
        String key = "Mary has one cat"; // 16bytes

        // AES only supports key sizes of 16, 24 or 32 bytes.
        // You either need to provide exactly that amount or you derive the key from
        // what you type in.

        String url = "src\\aes\\aes-file\\input.txt";
        File inputFile = new File(url);

        File encryptedFile = new File("src\\aes\\aes-file\\en.txt");
        File decryptedFile = new File("src\\aes\\aes-file\\de.txt");

        try {
            CryptoUtils.encrypt(key, inputFile, encryptedFile);
            CryptoUtils.decrypt(key, encryptedFile, decryptedFile);
        } catch (CryptoException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

}
