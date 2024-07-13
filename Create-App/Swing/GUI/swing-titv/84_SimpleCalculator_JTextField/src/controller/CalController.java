package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.CalView;

public class CalController implements ActionListener {

    private CalView view;

    public CalController(CalView view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();

        // cách làm khi ta để controller trong view
        // if (button.equals("+")) {
        // view.calculate("+");
        // } else if (button.equals("-")) {
        // view.calculate("-");
        // } else if (button.equals("*")) {
        // view.calculate("*");
        // } else if (button.equals("/")) {
        // view.calculate("/");
        // } else if (button.equals("^")) {
        // view.calculate("^");
        // } else {
        // view.calculate("%");
        // }

        // cách làm khi ta tách riêng hẳn hoàn toàn, chỉ cần gọi thằng view chấm tới các
        // method là xong (method của view đã gọi đến method của model)
        if (button.equals("+")) {
            view.plus();
        } else if (button.equals("-")) {
            view.minus();
        } else if (button.equals("*")) {
            view.multiply();
        } else if (button.equals("/")) {
            view.divide();
        } else if (button.equals("^")) {
            view.power();
        } else {
            view.modulo();
        }

    }

}