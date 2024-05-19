package multiple;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI {

    public GUI() {
        JFrame frame = new JFrame("Multiple Frame");

        JFrame btn1Frame = new JFrame("Button 1");

        JFrame btn2Frame = new JFrame("Button 2");

        JPanel panel = new JPanel();

        GridLayout gridLayout = new GridLayout(1, 2, 5, 5);

        JButton btn1 = new JButton("1");

        JButton btn2 = new JButton("2");

        panel.setLayout(gridLayout);

        panel.add(btn1);

        panel.add(btn2);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn1Frame.setSize(400, 400);
                btn1Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                btn1Frame.setLocationRelativeTo(null);
                btn1Frame.setVisible(true);
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn2Frame.setSize(400, 400);
                btn2Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                btn2Frame.setLocationRelativeTo(null);
                btn2Frame.setVisible(true);
            }
        });

        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new GUI();
    }
}
