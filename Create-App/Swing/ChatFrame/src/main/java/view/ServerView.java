package view;

import socket.Server;

import javax.swing.*;
import java.awt.*;

public class ServerView extends JFrame{

    private JLabel label = new JLabel("Start server", JLabel.CENTER);
    private JPanel jPanel = new JPanel(new BorderLayout());
    private JPanel jPanel_button = new JPanel(new FlowLayout(FlowLayout.CENTER));
    Toggle toggle = new Toggle();
    private Server server;

    public ServerView(Server server){
        this.setSize(200, 120);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.server = server;
        init();
        doAction();
    }

    public void init(){
        label.setFont(new Font("Dialog", Font.PLAIN, 20));
        jPanel.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        jPanel_button.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        jPanel_button.add(toggle);
        jPanel.add(label, BorderLayout.NORTH);
        jPanel.add(jPanel_button, BorderLayout.CENTER);
        this.add(jPanel, BorderLayout.CENTER);
    }

    public void doAction(){
        toggle.addEventSelected((selected) -> {
            if(selected){
                server.startServer();
                label.setForeground(Color.RED);
                label.setText("Stop server");
            } else {
                server.closeServerSocket();
                label.setForeground(Color.BLACK);
                label.setText("Start server");
            }
        });
    }

}
