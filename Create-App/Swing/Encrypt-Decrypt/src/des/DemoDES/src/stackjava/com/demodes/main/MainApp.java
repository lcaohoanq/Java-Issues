package stackjava.com.demodes.main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class MainApp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblKey;
	private JTextField textField;
	private JLabel lblOriginalText;
	private JTextArea textAreaOriginal;
	private JTextArea textAreaEncrypted;
	private JLabel lblEncryptedText;
	private JTextArea textAreaDycrypted;
	private JLabel lblDecryptedText;
	private JButton btnEncrypt;
	private JButton buttonDecrypt;

	/**
	 * Launch the application.
	 */
        
        //key: 64bits ~ 8 bytes (nhưng chỉ dùng 56bits) 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp frame = new MainApp();
					frame.setVisible(true);
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public void encrypt() {
		try {
			String originalText = textAreaOriginal.getText();
			String key = textField.getText();
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "DES");
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5PADDING");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
			byte[] byteEncrypted = cipher.doFinal(originalText.getBytes());
			String encrypted = Base64.getEncoder().encodeToString(byteEncrypted);
			textAreaEncrypted.setText(encrypted);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void decrypt() {
		try {
			String encryptText = textAreaEncrypted.getText();
			String key = textField.getText();
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "DES");
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);
			byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptText));
			textAreaDycrypted.setText(new String(decrypted));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 */
	public MainApp() {
		setTitle("DES Encryption - stackjava.com");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 249);
		this.contentPane = new JPanel();
		this.contentPane.setBackground(SystemColor.control);
		this.contentPane.setForeground(Color.WHITE);
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		
		this.lblKey = new JLabel("Key: ");
		this.lblKey.setBounds(10, 11, 46, 14);
		this.contentPane.add(this.lblKey);
		
		this.textField = new JTextField();
		this.textField.setBounds(48, 8, 146, 20);
		this.contentPane.add(this.textField);
		this.textField.setColumns(10);
		
		this.lblOriginalText = new JLabel("Original text: ");
		this.lblOriginalText.setBounds(10, 43, 76, 14);
		this.contentPane.add(this.lblOriginalText);
		
		this.textAreaOriginal = new JTextArea();
		this.textAreaOriginal.setLineWrap(true);
		this.textAreaOriginal.setBounds(10, 68, 200, 121);
		this.contentPane.add(this.textAreaOriginal);
		
		this.textAreaEncrypted = new JTextArea();
		this.textAreaEncrypted.setLineWrap(true);
		this.textAreaEncrypted.setBounds(337, 68, 200, 121);
		this.contentPane.add(this.textAreaEncrypted);
		
		this.lblEncryptedText = new JLabel("Encrypted text: ");
		this.lblEncryptedText.setBounds(337, 43, 95, 14);
		this.contentPane.add(this.lblEncryptedText);
		
		this.textAreaDycrypted = new JTextArea();
		this.textAreaDycrypted.setLineWrap(true);
		this.textAreaDycrypted.setBounds(678, 68, 200, 121);
		this.contentPane.add(this.textAreaDycrypted);
		
		this.lblDecryptedText = new JLabel("Decrypted text: ");
		this.lblDecryptedText.setBounds(678, 43, 105, 14);
		this.contentPane.add(this.lblDecryptedText);
		
		this.btnEncrypt = new JButton("Encrypt >>");
		this.btnEncrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				encrypt();
			}
		});
		this.btnEncrypt.setBounds(220, 108, 107, 23);
		this.contentPane.add(this.btnEncrypt);
		
		this.buttonDecrypt = new JButton("Decrypt >>");
		this.buttonDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				decrypt();
			}
		});
		this.buttonDecrypt.setBounds(558, 108, 107, 23);
		this.contentPane.add(this.buttonDecrypt);
	}

}
