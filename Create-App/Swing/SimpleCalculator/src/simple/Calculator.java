package simple;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Calculator extends JFrame {

    public Calculator() {

        this.setTitle("My Calculator");
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField jTextField = new JTextField(50);
        JPanel jPanel_head = new JPanel();
        jPanel_head.setLayout(new BorderLayout());
        jPanel_head.add(jTextField, BorderLayout.CENTER);

        /*
        for(int i=1;i<=9;i++)
            {
                JButton btn = new JButton(String.valueOf(i));
                btn.setBackground(Color.BLACK);
                btn.setForeground(Color.GRAY);
                p3.add(btn);
            }
         */
        JButton jButton_0 = new JButton("0");
        jButton_0.setBackground(Color.RED);
        jButton_0.setForeground(Color.YELLOW);
        
        JButton jButton_1 = new JButton("1");
        JButton jButton_2 = new JButton("2");
        JButton jButton_3 = new JButton("3");
        JButton jButton_4 = new JButton("4");
        JButton jButton_5 = new JButton("5");
        JButton jButton_6 = new JButton("6");
        JButton jButton_7 = new JButton("7");
        JButton jButton_8 = new JButton("8");
        JButton jButton_9 = new JButton("9");
        JButton jButton_add = new JButton("+");
        JButton jButton_sub = new JButton("-");
        JButton jButton_mul = new JButton("*");
        JButton jButton_div = new JButton("/");
        JButton jButton_equ = new JButton("=");
        JPanel jPanel_buttons = new JPanel(new GridLayout(5, 3));

//        this.setLayout(new FlowLayout());
        jPanel_buttons.add(jButton_0);
        jPanel_buttons.add(jButton_1);
        jPanel_buttons.add(jButton_2);
        jPanel_buttons.add(jButton_3);
        jPanel_buttons.add(jButton_4);
        jPanel_buttons.add(jButton_5);
        jPanel_buttons.add(jButton_6);
        jPanel_buttons.add(jButton_7);
        jPanel_buttons.add(jButton_8);
        jPanel_buttons.add(jButton_9);
        jPanel_buttons.add(jButton_add);
        jPanel_buttons.add(jButton_sub);
        jPanel_buttons.add(jButton_mul);
        jPanel_buttons.add(jButton_div);
        jPanel_buttons.add(jButton_equ);

        this.setLayout(new BorderLayout());
        this.add(jPanel_head, BorderLayout.NORTH);
        this.add(jPanel_buttons, BorderLayout.CENTER);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        //look and feel của macos
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new Calculator();
        } catch (Exception e){
            e.printStackTrace();
        }
        
        
    }

}
