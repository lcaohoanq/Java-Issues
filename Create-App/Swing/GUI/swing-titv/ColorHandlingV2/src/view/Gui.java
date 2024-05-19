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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import model.AppModel;

public class Gui extends JFrame {

  private AppModel model;

  JButton jButton_submit = new JButton("Submit");
  ;

  JLabel jLabel;

  JPanel jPanelBottom = new JPanel(new BorderLayout());
  JLabel jLabel_textColor = new JLabel("Enter Text Color", JLabel.LEFT);
  public static JTextField jTextField_textColor = new JTextField(10);
  JPanel panel_textColor = new JPanel();

  JLabel jLabel_backgroundColor = new JLabel("Enter Background Color", JLabel.LEFT);
  public static JTextField jTextField_backgroundColor = new JTextField(10);
  JPanel panel_backgroundColor = new JPanel();


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

    Dimension buttonSize = new Dimension(80, 40); // Adjust the width and height as needed

    EmptyBorder emptyBorder = new EmptyBorder(10, 10, 10, 10);

    jButton_submit.addActionListener(ac);

    panel_textColor.add(jLabel_textColor);
    panel_textColor.add(jTextField_textColor);
    panel_backgroundColor.add(jLabel_backgroundColor);
    panel_backgroundColor.add(jTextField_backgroundColor);
    jPanelBottom.add(panel_textColor, BorderLayout.NORTH);
    jPanelBottom.add(panel_backgroundColor, BorderLayout.CENTER);
    jPanelBottom.add(jButton_submit, BorderLayout.SOUTH);

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
    this.jLabel.setForeground(color);
  }

  public void setBackGroundColor(Color color) {
    this.jPanelTop.setBackground(color);
  }

}