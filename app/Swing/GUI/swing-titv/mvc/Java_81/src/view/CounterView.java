package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.*;
import controller.CounterListener;
import model.CounterModel;

public class CounterView extends JFrame {
    public CounterModel counterModel;

    private JButton jButton_up;
    private JButton jButton_down;
    public JLabel jLabel_number;
    private JPanel jPanel;
    private JPanel jPanel_reset;
    private JButton jButton_reset;

    public CounterView() {
        this.counterModel = new CounterModel();
        this.init();
        this.setVisible(true);
        // this.pack();
    }

    public void init() {
        this.setTitle("Counter");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);

        // !kêu thằng Controller lắng nghe sự kiện của thằng View
        ActionListener ac = new CounterListener(this);

        jButton_up = new JButton("UP");
        jButton_up.addActionListener(ac);
        // jButton_up.addActionListener(new CounterListener(this));
        jButton_down = new JButton("DOWN");
        jButton_down.addActionListener(ac);

        jButton_reset = new JButton("RESET");
        jButton_reset.addActionListener(ac);
        // jLabel_number = new JLabel(this.counterModel.getValue() + "");
        jLabel_number = new JLabel(Integer.toString(this.counterModel.getValue()), JLabel.CENTER);
        jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        jPanel.add(jButton_up, BorderLayout.WEST);
        jPanel.add(jLabel_number, BorderLayout.CENTER);
        jPanel.add(jButton_down, BorderLayout.EAST);
        jPanel.add(jButton_reset, BorderLayout.SOUTH);

        this.setLayout(new BorderLayout()); // set Layout cho main frame
        this.add(jPanel); // add panel vào main frame
    }

    public void update(String btnValue) {
        if (btnValue.equals("UP")) {
            this.counterModel.increment();
            this.jLabel_number.setText(Integer.toString(this.counterModel.getValue()));
        } else {
            this.counterModel.decrement();
            this.jLabel_number.setText(Integer.toString(this.counterModel.getValue()));
        }
    }

    // ! cách 3
    public void increment() {
        this.counterModel.increment();
        this.jLabel_number.setText(Integer.toString(this.counterModel.getValue()));
    }

    public void decrement() {
        this.counterModel.decrement();
        this.jLabel_number.setText(Integer.toString(this.counterModel.getValue()));
    }

    public void reset() {
        this.counterModel.reset();
        this.jLabel_number.setText(Integer.toString(this.counterModel.getValue()));
    }
}
