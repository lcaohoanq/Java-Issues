package single;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SnakeGameMenu {

    public SnakeGameMenu() {
        JFrame frame = new JFrame("Snake Game");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        //cần phải tạo ra 3 panel chứa 3 thành phần: username, pwd, button
        JPanel usernamePanel = new JPanel(new FlowLayout());
        JPanel passwordPanel = new JPanel(new FlowLayout());
        JPanel buttonPanel = new JPanel(new FlowLayout());

        JLabel user = new JLabel("username");
        JLabel pwd = new JLabel("password");

        JTextField username = new JTextField(10);
        JTextField password = new JPasswordField(10);

        JButton play = new JButton("Play");

        usernamePanel.add(user);
        usernamePanel.add(username);

        passwordPanel.add(pwd);
        passwordPanel.add(password);

        buttonPanel.add(play);
        //panel tổng sẽ dùng BorderLayout.Center
        panel.add(usernamePanel);
        panel.add(passwordPanel);
        panel.add(buttonPanel);

//        frame.getContentPane().add(panel);
        
        frame.add(panel, BorderLayout.PAGE_START); //The PAGE_START of the BorderLayout respects the preferred height of the component.
        

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new SnakeGameMenu();
    }

}
