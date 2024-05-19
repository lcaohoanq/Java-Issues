package casio;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class HL100LB {
  JFrame frame = new JFrame("HL-100LB");
  JPanel panel_main = new JPanel(new BorderLayout());
  JPanel panel_info = new JPanel(); //JLabel 3 dong, BoxLayout Y_AXIS
  JPanel panel_calculate = new JPanel(new BorderLayout()); //JTextArea 3 dong
  JPanel panel_buttons = new JPanel(new GridLayout(5,5,3,3)); //JButton 5 hang 5 cot
  JLabel company = new JLabel("Casio");
  JLabel type = new JLabel("Electronic Calculator");
  JLabel model = new JLabel("HL-100LB");
  JTextArea viewer = new JTextArea(3, 50);
  JButton button;
  String[] btnList = {"OFF", "MRC", "M-", "M+", "÷", "%", "7", "8", "9", "×", "√", "4", "5", "6", "-", "C", "1", "2", "3", "+", "AC", "0", ".","=", "+"};
  public HL100LB() {

    panel_info.setLayout(new BoxLayout(panel_info, BoxLayout.Y_AXIS));


    panel_info.add(company);
    panel_info.add(type);
    panel_info.add(model);


    viewer.setEditable(false);
//    panel_calculate.setLayout();
    panel_calculate.add(viewer);

    for(int i = 0; i < 25; i++) {
       button = new JButton(btnList[i]);
        button.addActionListener(new ClickButton());
      panel_buttons.add(button);
    }

    panel_main.add(panel_info, BorderLayout.NORTH);
    panel_main.add(panel_calculate, BorderLayout.CENTER);
    panel_main.add(panel_buttons, BorderLayout.SOUTH);

    frame.setLayout(new BorderLayout());
    frame.add(panel_main, BorderLayout.CENTER);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 400);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    try{
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); //mac os
      new HL100LB();
    }catch(Exception e) {
      e.printStackTrace();
    }
  }

  private class ClickButton implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
      String btnText = ((JButton) e.getSource()).getText();
      viewer.append(btnText);
    }
  }
}
