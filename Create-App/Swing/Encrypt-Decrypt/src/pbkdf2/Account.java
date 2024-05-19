package pbkdf2;

/**
 *
 * @author Admin
 */
public class Account {
    private String username;
    private String password;
    private String hashedPassword;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account(String username, String password, String hashedPassword) {
        this.username = username;
        this.password = password;
        this.hashedPassword = hashedPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    @Override
    public String toString() {
        return "Account{" + "username=" + username + "\n" + ", password=" + password + "\n" + ", hashedPassword=" + hashedPassword + '}';
    }
    
    
    
}
