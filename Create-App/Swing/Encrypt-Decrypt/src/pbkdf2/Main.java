package pbkdf2;

/**
 *
 * @author Admin
 */
public class Main {

     public static void main(String[] args) {
        // Assume you have a user with the following credentials
        String username = "user123";
        String providedPassword = "Hello"; // This is the password provided by the user during login
       

        // During user registration, hash the password and store the hashed version in your database
        PasswordAuthentication passwordAuthentication = new PasswordAuthentication();
        String hashedPassword = passwordAuthentication.hash(providedPassword);

        // In your database, you would store 'username' and 'hashedPassword' for the user

        // During user login or authentication attempt
        String storedHashedPassword = getHashedPasswordFromDatabase(username);

        // Check if the provided password is correct
        boolean isMatch = passwordAuthentication.authenticate(providedPassword.toCharArray(), storedHashedPassword);

        if (isMatch) {
            System.out.println("Authentication successful!");
            // Proceed with allowing the user to log in
        } else {
            System.out.println("Authentication failed. Invalid password.");
            // Handle the case where authentication fails
        }
    }

    // In a real application, you would fetch the hashed password from your database based on the provided username
    private static String getHashedPasswordFromDatabase(String username) {
        // In this example, assume a hardcoded hashed password for simplicity
        return "$31$16$G2M1ezncsGKvlv0DW+JQwA$...."; // Replace with the actual hashed password
    }

}
