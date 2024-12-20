package pbkdf2;

/**
 *
 * @author Admin
 */
public class DemoMain {
    public static void main(String[] args) {
        Account ac = new Account("admin", "Luucaohoang16041dfsdfsdfsdfsdfasfasdfasdfsdfasfasdf");
        
        PasswordAuthentication pa = new PasswordAuthentication();
        
        ac.setHashedPassword(pa.hash(ac.getPassword()));
        
        String storeHashedPassword = ac.getHashedPassword();
        System.out.println("hashed password: " + ac.toString());
        
        //tí config lại là Account chỉ chứa username với hashedPassword thôi, và khi hash thì mình sẽ set get password user đã nhập
        //và set lại giá trị hashed
        
        // Check if the provided password is correct
        boolean isMatch = pa.authenticate("Luucaohoang16041dfsdfsdfsdfsdfasfasdfasdfsdfasfasdf".toCharArray(), storeHashedPassword);

        if (isMatch) {
            System.out.println("Authentication successful!");
            // Proceed with allowing the user to log in
        } else {
            System.out.println("Authentication failed. Invalid password.");
            // Handle the case where authentication fails
        }
    }
}
