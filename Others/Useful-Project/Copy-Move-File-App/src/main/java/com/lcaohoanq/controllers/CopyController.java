package com.lcaohoanq.controllers;

import com.lcaohoanq.views.CopyFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CopyController implements ActionListener {
    private CopyFrame copyFrame;

    public CopyController(CopyFrame copyFrame){
        this.copyFrame = copyFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("You are in the Copy Action");
    }
}
