package com.lcaohoanq;

import java.awt.EventQueue;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new GitCloneApp().setVisible(true);
        });
    }

    // test
    // https://github.com/lcaohoanq/Web-Snake-Game-Frontend
}