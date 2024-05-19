package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ButtonController;
import model.ButtonModel;

public class ButtonView extends JFrame {
    // trong view tạo UI
    // ta cần phải hứng lại cái model
    private ButtonModel model;
    private JLabel jLabel;

    public ButtonView() {
        this.model = new ButtonModel();
        initUI();
        setVisible(true);
    }

    private void initUI() {
        setSize(400, 400);
        JPanel jPanel_buttons = new JPanel(new GridLayout(2, 2));
        JPanel jPanel = new JPanel(new BorderLayout());
        jLabel = new JLabel("-----", JLabel.CENTER);

        Font font = new Font("Roboto", Font.BOLD, 25);
        JButton jButton_1 = new JButton("1");
        JButton jButton_2 = new JButton("2");
        JButton jButton_3 = new JButton("3");
        JButton jButton_4 = new JButton("4");
        jButton_1.setFont(font);
        jButton_2.setFont(font);
        jButton_3.setFont(font);
        jButton_4.setFont(font);

        ActionListener ac = new ButtonController(this);
        jButton_1.addActionListener(ac);
        jButton_2.addActionListener(ac);
        jButton_3.addActionListener(ac);
        jButton_4.addActionListener(ac);

        jPanel_buttons.add(jButton_1);
        jPanel_buttons.add(jButton_2);
        jPanel_buttons.add(jButton_3);
        jPanel_buttons.add(jButton_4);

        jPanel.add(jPanel_buttons, BorderLayout.CENTER);
        jPanel.add(jLabel, BorderLayout.SOUTH);

        add(jPanel); // add jPanel vào Frame
    }

    public void changeText(String msg) {
        this.model.setText("Clicked button: " + msg);
        System.out.println(model.getText());
        this.jLabel.setText("Clicked button: " + msg);
        System.out.println(jLabel.getText());
    }

}
