/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rsa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

public class Encryption {

    public static void main(String[] args) {
        try {
            // Đọc file chứa public key
            FileInputStream fis = new FileInputStream("D:\\PIED\\JAVA\\Java Project\\Encrypt-Decrypt\\src\\rsa\\publicKey.rsa");
            byte[] b = new byte[fis.available()];
            fis.read(b);
            fis.close();

            // Tạo public key
            X509EncodedKeySpec spec = new X509EncodedKeySpec(b);
            KeyFactory factory = KeyFactory.getInstance("RSA");
            PublicKey pubKey = factory.generatePublic(spec);

            // Mã hoá dữ liệu
            Cipher c = Cipher.getInstance("RSA");
            c.init(Cipher.ENCRYPT_MODE, pubKey);

//            String msg = "helloworld";
//            byte encryptOut[] = c.doFinal(msg.getBytes());
            String url = "D:\\PIED\\JAVA\\Java Project\\Encrypt-Decrypt\\src\\rsa\\input.txt";
            byte encryptOut[] = c.doFinal(url.getBytes());
            String strEncrypt = Base64.getEncoder().encodeToString(encryptOut);
            
            writeToFile(strEncrypt);
            
            System.out.println("Chuỗi sau khi mã hoá: " + "\n" + strEncrypt);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void writeToFile(String str) throws Exception {

        String url = "D:\\PIED\\JAVA\\Java Project\\Encrypt-Decrypt\\src\\rsa\\en.txt";
        
        BufferedWriter bufferedWriter = null;

        try {
            Writer writer = new FileWriter(url);

            bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.write(str);
            
            System.out.println("Write file Successfully");

        } catch (Exception e){
            throw new Exception("Loi String roi ong chau oi");
        }

    }
}
