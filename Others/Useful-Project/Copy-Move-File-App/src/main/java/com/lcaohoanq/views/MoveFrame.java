package com.lcaohoanq.views;

import javax.swing.JButton;

public class MoveFrame extends FunctionFrame{


    public MoveFrame() {
        super();
        moveButton = new JButton("Move");
        this.setTitle("Move Files");
    }

    @Override
    protected void doAction() {
        super.doAction();
    }

    public static void main(String[] args) {
        new MoveFrame().setVisible(true);
    }
}