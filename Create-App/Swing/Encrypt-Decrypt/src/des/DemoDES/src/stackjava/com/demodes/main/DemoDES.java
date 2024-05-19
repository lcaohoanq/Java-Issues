package stackjava.com.demodes.main;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class DemoDES {
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		String SECRET_KEY = "12345678";
		SecretKeySpec skeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), "DES");
		
		String original = "stackjava.com";
		
		Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5PADDING");
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
		byte[] byteEncrypted = cipher.doFinal(original.getBytes());
		String encrypted =  Base64.getEncoder().encodeToString(byteEncrypted);
		
		
		cipher.init(Cipher.DECRYPT_MODE, skeySpec);
		byte[] byteDecrypted = cipher.doFinal(byteEncrypted);
		String decrypted = new String(byteDecrypted);
		
		System.out.println("original  text: " + original);
		System.out.println("encrypted text: " + encrypted);
		System.out.println("decrypted text: " + decrypted);
		
	}
}
