/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rsa;

import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

public class Decryption {

    public static void main(String[] args) {
        try {
            // Đọc file chứa private key
            FileInputStream fis = new FileInputStream("D:\\PIED\\JAVA\\Java Project\\Encrypt-Decrypt\\src\\rsa\\privateKey.rsa");
            byte[] b = new byte[fis.available()];
            fis.read(b);
            fis.close();

            // Tạo private key
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(b);
            KeyFactory factory = KeyFactory.getInstance("RSA");
            PrivateKey priKey = factory.generatePrivate(spec);

            // Giải mã dữ liệu
            Cipher c = Cipher.getInstance("RSA");
            c.init(Cipher.DECRYPT_MODE, priKey);
            byte decryptOut[] = c.doFinal(Base64.getDecoder().decode(
                    "GH6+3S0y5jJ+z+kD9FA8Au3W23QHQWH3+yJM8a1Dv9bJUrd4ZBSWy6CxJ/jwf6eCOTRcL3cMdN33NETdG9iJBeLxxbH5iu+hjmJB+N5y9ro1mkdLwFgNALY+mf47dzvmxb+GI790jooyfCNi6vKtETEnJq65hJrBwnJjInFwA8U="));
            System.out.println("Dữ liệu sau khi giải mã: " + new String(decryptOut));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
