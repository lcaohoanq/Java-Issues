package view;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.CalController;

import java.awt.event.ActionListener;

import model.CalModel;

public class CalView extends JFrame {

    private CalModel calModel;

    JTextField tf_1;
    JTextField tf_2;
    JTextField tf_3;

    public CalView() {
        this.calModel = new CalModel();
        initCalView();
        setVisible(true);
    }

    public void initCalView() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // 4 panel
        // 1 panel tổng dùng boxlayout Y_AXIS
        JPanel panel_1 = new JPanel();
        JLabel label_1 = new JLabel("1st Value");
        tf_1 = new JTextField(5);
        panel_1.add(label_1);
        panel_1.add(tf_1);

        JPanel panel_2 = new JPanel();
        JLabel label_2 = new JLabel("2nd Value");
        tf_2 = new JTextField(10);
        panel_2.add(label_2);
        panel_2.add(tf_2);

        JPanel panel_3 = new JPanel();
        JLabel label_3 = new JLabel("Result");
        tf_3 = new JTextField(10);
        panel_3.add(label_3);
        panel_3.add(tf_3);

        JPanel panel_4 = new JPanel();

        JButton btn_addition = new JButton("+");
        JButton btn_subtraction = new JButton("-");
        JButton btn_multiplication = new JButton("*");
        JButton btn_division = new JButton("/");
        JButton btn_power = new JButton("^");
        JButton btn_modulo = new JButton("%");
        panel_4.add(btn_addition);
        panel_4.add(btn_subtraction);
        panel_4.add(btn_multiplication);
        panel_4.add(btn_division);
        panel_4.add(btn_power);
        panel_4.add(btn_modulo);

        ActionListener ac = new CalController(this);
        // btn_addition.addActionListener(this); //nếu mình sử dụng this ở đây thì có
        // nghĩa là mình cần phải implements cái ActionListener ngay trong chính class
        // View này
        // nhưng mình đã tách ra một class là controller nó implement luôn cái
        // ActionListener rồi, nên mình chỉ cần tạo một đối tượng của class controller
        // này rồi pass vô là xong
        btn_addition.addActionListener(ac);
        btn_subtraction.addActionListener(ac);
        btn_multiplication.addActionListener(ac);
        btn_division.addActionListener(ac);
        btn_power.addActionListener(ac);
        btn_modulo.addActionListener(ac);

        // add 4 panel vào frame
        panel.add(panel_1);
        panel.add(panel_2);
        panel.add(panel_3);
        panel.add(panel_4);

        add(panel);

        setTitle("Calculator");
        // setSize(300, 300);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // setResizable(false);
    }

    public boolean isEmpty() {
        if (tf_1.getText().isEmpty() || tf_2.getText().isEmpty()) {
            return true;
        }
        return false;
    }

    // Đây là cách code trong view
    public void calculate(String msg) {
        if (msg.equals("+")) {
            this.tf_3.setText(Integer.toString(Integer.parseInt(tf_1.getText()) + Integer.parseInt(tf_2.getText())));
        } else if (msg.equals("-")) {
            this.tf_3.setText(Integer.toString(Integer.parseInt(tf_1.getText()) - Integer.parseInt(tf_2.getText())));
        } else if (msg.equals("*")) {
            this.tf_3.setText(Integer.toString(Integer.parseInt(tf_1.getText()) * Integer.parseInt(tf_2.getText())));
        } else if (msg.equals("/")) {
            this.tf_3.setText(Integer.toString(Integer.parseInt(tf_1.getText()) / Integer.parseInt(tf_2.getText())));
        } else if (msg.equals("^")) {
            this.tf_3.setText(Integer
                    .toString((int) Math.pow(Integer.parseInt(tf_1.getText()), Integer.parseInt(tf_2.getText()))));
        } else if (msg.equals("%")) {
            this.tf_3.setText(Integer.toString(Integer.parseInt(tf_1.getText()) % Integer.parseInt(tf_2.getText())));

        }
    }

    // Đây là cách code trong model
    public void plus() {
        float firstValue = Float.parseFloat(tf_1.getText());
        float secondValue = Float.parseFloat(tf_2.getText());
        this.calModel.setFirstValue(firstValue);
        this.calModel.setSecondValue(secondValue);
        this.calModel.plus();
        this.tf_3.setText(Float.toString(this.calModel.getResult()));
    }

    public void minus() {
        float firstValue = Float.parseFloat(tf_1.getText());
        float secondValue = Float.parseFloat(tf_2.getText());
        this.calModel.setFirstValue(firstValue);
        this.calModel.setSecondValue(secondValue);
        this.calModel.minus();
        this.tf_3.setText(Float.toString(this.calModel.getResult()));
    }

    public void multiply() {
        float firstValue = Float.parseFloat(tf_1.getText());
        float secondValue = Float.parseFloat(tf_2.getText());
        this.calModel.setFirstValue(firstValue);
        this.calModel.setSecondValue(secondValue);
        this.calModel.multiply();
        this.tf_3.setText(Float.toString(this.calModel.getResult()));
    }

    public void divide() {
        float firstValue = Float.parseFloat(tf_1.getText());
        float secondValue = Float.parseFloat(tf_2.getText());
        this.calModel.setFirstValue(firstValue);
        this.calModel.setSecondValue(secondValue);
        this.calModel.divide();
        this.tf_3.setText(Float.toString(this.calModel.getResult()));
    }

    public void power() {
        float firstValue = Float.parseFloat(tf_1.getText());
        float secondValue = Float.parseFloat(tf_2.getText());
        this.calModel.setFirstValue(firstValue);
        this.calModel.setSecondValue(secondValue);
        this.calModel.power();
        this.tf_3.setText(Float.toString(this.calModel.getResult()));
    }

    public void modulo() {
        float firstValue = Float.parseFloat(tf_1.getText());
        float secondValue = Float.parseFloat(tf_2.getText());
        this.calModel.setFirstValue(firstValue);
        this.calModel.setSecondValue(secondValue);
        this.calModel.modulo();
        this.tf_3.setText(Float.toString(this.calModel.getResult()));
    }

}
