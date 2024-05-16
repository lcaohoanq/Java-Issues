package com.lcaohoanq;

import java.awt.EventQueue;

class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new GUI().setVisible(true);
        });
    }
}