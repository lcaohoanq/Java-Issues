package runtime;

import javax.swing.*;

public class Program extends JFrame {

    public Program() {

        JPanel panel = new JPanel(); //BoxLayout Y
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        //3 panel nhỏ
        JPanel username_panel = new JPanel(new );
        

        setTitle("Login App");
        setSize(300, 150);
        // pack(); //
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Program();
    }

}
