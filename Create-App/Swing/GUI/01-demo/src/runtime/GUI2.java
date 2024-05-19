package runtime;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//không cần phải implement ActionListner nữa
public class GUI2 extends JFrame {

    private JPanel panel;

    private JLabel label1, label2;

    private JButton btn1, btn2;

    int count1, count2 = 0;

    public GUI2() {

        panel = new JPanel(new FlowLayout()); //tạo một đối tượng tạo layout

        label1 = new JLabel("Button 1 clicked: 0");
        panel.add(label1);

         btn1 = new JButton("Click me!");
        panel.add(btn1);

        label2 = new JLabel("Button 2 clicked: 0");
        panel.add(label2);

         btn2 = new JButton("Click me!");
        panel.add(btn2);

        this.setContentPane(panel);

//        btn1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                label1.setText("Button 1 clicked: " + (++count1));
//
//            }
//        });
//
//        btn2.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                label2.setText("Button 2 clicked: " + (++count2));
//            }
//        });

        btn1.addActionListener(new Button1Handler());
        
        btn2.addActionListener(new Button2Handler());

        this.setSize(640, 480);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);

    }

    private class Button1Handler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            label1.setText("Button 1 clicked: " + (++count1));
            btn1.setText("I am button 1");
        }

    }

    private class Button2Handler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            label2.setText("Button 2 clicked: " + (++count2));
            btn2.setText("I am button 2");
        }

    }

    public static void main(String[] args) {
        GUI2 program = new GUI2();
    }

}
