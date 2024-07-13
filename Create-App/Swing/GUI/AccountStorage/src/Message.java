import javax.swing.JOptionPane;

public class Message {
    public static void IS_LOGIN_SUCCESS() {
        JOptionPane.showMessageDialog(null, "Login success", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void IS_LOGIN_FAILED() {
        JOptionPane.showMessageDialog(null, "Login failed", "Failed", JOptionPane.ERROR_MESSAGE);
    }

    public static void IS_WRONG_USERNAME_OR_PASSWORD() {
        JOptionPane.showMessageDialog(null, "Wrong username or password", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void IS_EMPTY_USERNAME_OR_PASSWORD() {
        JOptionPane.showMessageDialog(null, "Username or password cannot be empty", "Error",
                JOptionPane.WARNING_MESSAGE);
    }

    public static void IS_EMPTY_FIELD() {
        JOptionPane.showMessageDialog(null, "Each field cannot be empty", "Error",
                JOptionPane.WARNING_MESSAGE);
    }

    public static void IS_NOTHING_TO_WRITE() {
        JOptionPane.showMessageDialog(null, "Nothing to write", "Error",
                JOptionPane.WARNING_MESSAGE);
    }

    public static void IS_WELLCOME(String msg) {
        JOptionPane.showMessageDialog(null, "Hello " + msg, null, JOptionPane.INFORMATION_MESSAGE);
    }
    public static void IS_WRITE_FILE_SUCCESS(String msg){
        JOptionPane.showMessageDialog(null, "Write file success at " + msg, null, JOptionPane.INFORMATION_MESSAGE);
    }
}
