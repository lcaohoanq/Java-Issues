package com.lcaohoanq.controllers;

import com.lcaohoanq.views.FunctionFrame;
import com.lcaohoanq.views.ProgressBarFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FunctionController implements ActionListener {
    private FunctionFrame functionFrame;
    public FunctionController(FunctionFrame functionFrame) {
        this.functionFrame = functionFrame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        ProgressBarFrame progressBarFrame = new ProgressBarFrame();
        progressBarFrame.setVisible(true);
        progressBarFrame.triggerAction();
    }
}
