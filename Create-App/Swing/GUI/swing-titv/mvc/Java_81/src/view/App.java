package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;

public class App extends JFrame {

    public App() {

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JButton up = new JButton("Up");
        JButton down = new JButton("Down");
        JLabel number = new JLabel("14");

        panel.add(up, BorderLayout.WEST); // phía bên trái
        panel.add(down, BorderLayout.EAST); // phía bên phải

        JPanel panelNumber = new JPanel();
        panelNumber.setLayout(new BorderLayout());
        panelNumber.add(number, BorderLayout.CENTER);

        panel.add(panelNumber, BorderLayout.CENTER); // phía giữa

        up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                int n = Integer.parseInt(number.getText());
                n++;
                number.setText(Integer.toString(n));
            }
        });

        down.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                int n = Integer.parseInt(number.getText());
                n--;
                number.setText(Integer.toString(n));
            }
        });

        add(panel);

        setTitle("Counter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new App();
    }
}
