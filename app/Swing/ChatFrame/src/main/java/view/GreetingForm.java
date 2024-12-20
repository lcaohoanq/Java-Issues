package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GreetingForm extends JFrame implements ActionListener {
    JLabel jLabel_Logo = new JLabel("Hello, welcome to my chat app", JLabel.CENTER);
    JLabel jLabel_Name = new JLabel("Please enter your name: ");
    JTextField jTextField_Name = new JTextField(20);
    JButton jButton_EnterButton = new JButton("Submit");
    JPanel jPanel = new JPanel(new GridLayout(2, 1));
    JPanel jPanel_middle = new JPanel(new GridLayout(2, 1));
    JPanel jPanel_button = new JPanel(new FlowLayout(FlowLayout.CENTER));
    String user = "";
    public GreetingForm(){
        this.setTitle("Greeting Form");
        this.setSize(300, 250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        init();
        doAction();
    }

    public void init(){
        jLabel_Name.setFont(new Font("Dialog", Font.PLAIN, 20));
        jTextField_Name.setFont(new Font("Dialog", Font.PLAIN, 15));
        jButton_EnterButton.setFont(new Font("Dialog", Font.BOLD, 20));
        jPanel.setBorder(new EmptyBorder(0, 30, 0, 30));
        jLabel_Name.setBorder(new EmptyBorder(0, 0, 10, 0));
        jButton_EnterButton.setPreferredSize(new Dimension(100, 50));
        jPanel_middle.setBorder(new EmptyBorder(20 , 0, 30, 0));
        jLabel_Name.setForeground(Color.BLUE);
        jButton_EnterButton.setBackground(Color.BLUE);
        jButton_EnterButton.setForeground(Color.WHITE);
        jPanel_middle.add(jLabel_Name);
        jPanel_middle.add(jTextField_Name);
        jPanel_button.add(jButton_EnterButton);
        jPanel.add(jPanel_middle);
        jPanel.add(jPanel_button);
        this.add(jPanel);
    }

    public void doAction(){
        jTextField_Name.addActionListener(new PressEnter());
        jButton_EnterButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jButton_EnterButton){
            if(jTextField_Name.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Please enter your name", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Welcome " + jTextField_Name.getText(), "Welcome", JOptionPane.INFORMATION_MESSAGE);
                EventQueue.invokeLater(()->{
                    ChatBox chatBox = new ChatBox(this.jTextField_Name.getText().trim());
                    chatBox.setVisible(true);
                    this.dispose();
                });
            }
        }
    }

    protected class PressEnter implements ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            jButton_EnterButton.doClick();
        }

    }
}
