/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Admin
 */
public class Entry {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(new Dimension(200,200));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        new LookAndFeelPicker(frame);
    }
}
