package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.CounterView;

public class CounterListener implements ActionListener {
    // !cần phải nhận vào một CounterView để biết xử lí cái gì
    private CounterView cv;

    public CounterListener(CounterView cv) {
        this.cv = cv;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // System.out.println("Clicked");

        // String src = e.getActionCommand();

        JButton btn = (JButton) e.getSource();
        String btnValue = btn.getText();

        // Cách 1: viết trong controller
        /*
         * if (btnValue.equals("UP")) {
         * //việc thay đổi giá trị là việc hiển thị ra màn hình của view, nếu mình viết
         * trong Controller như này
         * //!thì phải mở public ra cho view truy cập vào
         * cv.counterModel.increment();
         * cv.jLabel_number.setText(Integer.toString(cv.counterModel.getValue()));
         * } else {
         * cv.counterModel.decrement();
         * cv.jLabel_number.setText(Integer.toString(cv.counterModel.getValue()));
         * }
         */

        // cách 2: viết trong view một hàm public, vẫn xử lí btn bên view
        // cv.update(btnValue);

        // cách 3: tách riêng xử lí btn bên Controller
        if (btnValue.equals("UP")) {
            cv.increment();
        } else if (btnValue.equals("DOWN")) {
            cv.decrement();
        } else {
            cv.reset();
        }
    }

}
