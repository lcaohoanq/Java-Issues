package runtime;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class App {
    JPanel panel = new JPanel();

    JLabel user = new JLabel("Username");
    JTextField tf = new JTextField(10);

    JLabel password = new JLabel("Password");
    JPasswordField pf = new JPasswordField(10);
}
