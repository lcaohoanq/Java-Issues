package com.lcaohoanq;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Main extends JFrame implements ActionListener {

    public Main(){

        this.setVisible(true);
        this.setSize(200,200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new BorderLayout());

        JButton button = new JButton("Click me");
        button.setBackground(Color.GREEN);
        button.addActionListener(this);

        panel.add(button, BorderLayout.CENTER);

        this.add(panel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        queryOptions("select * from users");
        Notification.START_SPRING_SUCCESS();
    }

}

class Notification {
    public static void START_SPRING_SUCCESS() {
        JOptionPane.showMessageDialog(null, "Success start Spring Server", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}