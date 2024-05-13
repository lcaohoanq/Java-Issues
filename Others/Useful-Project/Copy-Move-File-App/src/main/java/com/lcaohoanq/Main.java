package com.lcaohoanq;

import com.lcaohoanq.views.MainFrame;
import java.awt.EventQueue;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }

}