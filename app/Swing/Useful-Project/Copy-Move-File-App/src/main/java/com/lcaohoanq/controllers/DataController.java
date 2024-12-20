package com.lcaohoanq.controllers;

import com.lcaohoanq.views.DataFrame;
import com.lcaohoanq.views.FunctionFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JOptionPane;

public class DataController implements ActionListener {

    private FunctionFrame functionFrame;
    public DataController(FunctionFrame functionFrame) {
        this.functionFrame = functionFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String filePath = functionFrame.getFilePath();
        if(filePath != null) {
            new DataFrame(new File(filePath)).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(functionFrame, "Please select a file to view data", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
