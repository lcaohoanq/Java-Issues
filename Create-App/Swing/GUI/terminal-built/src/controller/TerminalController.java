package controller;

import view.TerminalView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TerminalController implements ActionListener, KeyListener {

    private TerminalView terminalView;

    public TerminalController(TerminalView terminalView){
        this.terminalView = terminalView;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            terminalView.jTextArea.append("\nAdmin@Admin-PC MINGW64 /c/Windows/system32");
            terminalView.jTextArea.append("\n$ ");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
