package view;

import controller.AppController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JPanel;
import model.AppModel;

public class Gui extends JFrame {

    private AppModel model;

    JButton jButton_1; // chữ đỏ
    JButton jButton_2; // chữ vàng
    JButton jButton_3; // chữ xanh lá
    JButton jButton_4; // nền xanh dương
    JButton jButton_5; // nền cam
    JButton jButton_6; // nền hồng
    JLabel jLabel;

    JPanel jPanelTop;

    public Gui() {
        this.model = new AppModel();
        initGui();
        setVisible(true);
    }

    private void initGui() {
        JPanel jPanel = new JPanel(); // panel tổng
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        jPanelTop = new JPanel(new BorderLayout()); // panel trên chứa 1 JLabel Center
        jLabel = new JLabel("Hello World!", JLabel.CENTER);
        jLabel.setFont(new Font("Roboto", Font.BOLD, 30));
        jPanelTop.add(jLabel, BorderLayout.CENTER);

        ActionListener ac = new AppController(this);

        JPanel jPanelBottom = new JPanel(new GridLayout(2, 3, 5, 5)); // panel dưới grid 2x3
        jButton_1 = new JButton(); // chữ đỏ
        jButton_2 = new JButton(); // chữ vàng
        jButton_3 = new JButton(); // chữ xanh lá
        jButton_4 = new JButton(); // nền xanh dương
        jButton_5 = new JButton(); // nền cam
        jButton_6 = new JButton(); // nền hồng

        Dimension buttonSize = new Dimension(80, 40); // Adjust the width and height as needed
        jButton_1.setPreferredSize(buttonSize);
        jButton_2.setPreferredSize(buttonSize);
        jButton_3.setPreferredSize(buttonSize);
        jButton_4.setPreferredSize(buttonSize);
        jButton_5.setPreferredSize(buttonSize);
        jButton_6.setPreferredSize(buttonSize);

        jButton_1.setBackground(Color.RED);
        jButton_2.setBackground(Color.YELLOW);
        jButton_3.setBackground(Color.GREEN);
        jButton_4.setBackground(Color.BLUE);
        jButton_5.setBackground(Color.ORANGE);
        jButton_6.setBackground(Color.PINK);

        jButton_1.addActionListener(ac);
        jButton_2.addActionListener(ac);
        jButton_3.addActionListener(ac);
        jButton_4.addActionListener(ac);
        jButton_5.addActionListener(ac);
        jButton_6.addActionListener(ac);

        jPanelBottom.add(jButton_1);
        jPanelBottom.add(jButton_2);
        jPanelBottom.add(jButton_3);
        jPanelBottom.add(jButton_4);
        jPanelBottom.add(jButton_5);
        jPanelBottom.add(jButton_6);

        jPanel.add(jPanelTop);
        jPanel.add(jPanelBottom);

        add(jPanel);
        setTitle("Color Picker");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // public void setTextColor(String msg){
    // if(msg.equals("RED")){
    // this.jLabel.setForeground(Color.RED);
    // }else if(msg.equals("YELLOW")){
    // this.jLabel.setForeground(Color.YELLOW);
    // }else{
    // this.jLabel.setForeground(Color.GREEN);
    // }
    // }
    // public void setBackGroundColor(String msg){
    // if(msg.equals("BLUE")){
    // this.jPanelTop.setBackground(Color.BLUE);
    // }else if(msg.equals("ORANGE")){
    // this.jPanelTop.setBackground(Color.ORANGE);
    // }else{
    // this.jPanelTop.setBackground(Color.PINK);
    // }
    // }

    public void setTextColor(Color color) {
        this.jLabel.setForeground(color)
    public void setBackGroundColor(Color color) {
        this.jPanelTop.setBackground(color);
    }

}