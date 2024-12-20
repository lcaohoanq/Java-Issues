package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ButtonView;

public class ButtonController implements ActionListener {

    private ButtonView view;

    public ButtonController(ButtonView view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("0")) {
            view.changeText("0");
        } else if (e.getActionCommand().equals("1")) {
            view.changeText("1");
        } else if (e.getActionCommand().equals("2")) {
            view.changeText("2");
        } else {
            view.changeText("3");
        }

    }

}
