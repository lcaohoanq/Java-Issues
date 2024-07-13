package buttonHandling;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Button extends JFrame implements ActionListener {

    JPanel panel = new JPanel();

    JButton btn = new JButton("Click me");

    public Button() {
        setLayout(new BorderLayout());

        btn.setBackground(Color.GRAY);
        
        btn.addActionListener(this);

        panel.add(btn);
        add(panel, BorderLayout.CENTER);

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Button();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(btn.getText());
    }
}
