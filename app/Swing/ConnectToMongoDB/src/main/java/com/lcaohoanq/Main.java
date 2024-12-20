package com.lcaohoanq;

import java.awt.BorderLayout;
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
        queryOptions("select * from users where name = 'minhnhu'");
    }

    private void queryOptions(String require){
        if(require.equals("select * from users")){
            new DatabaseConnection().findAllUsers();
            Notification.QUERY_SUCCESS(require);
        }
        if(require.equals("select * from users where name = 'minhnhu'")){
            new DatabaseConnection().findUserByUsername("minhnhu");
            Notification.QUERY_SUCCESS(require);
        }
    }

}

class Notification {
    public static void QUERY_SUCCESS(String require) {
        JOptionPane.showMessageDialog(null, require + " success", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}