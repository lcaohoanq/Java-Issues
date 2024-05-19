package view;

import controller.TerminalController;

import javax.swing.*;
import java.awt.*;

public class TerminalView extends JFrame {

    public JTextArea jTextArea = new JTextArea(20,40);
    private JPanel jPanel_jTextArea = new JPanel(new BorderLayout());
    JPanel jPanel = new JPanel(new BorderLayout());
    public TerminalView(){
        this.setTitle("Terminal");
        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
//        this.pack();
        this.setVisible(true);
        init();
        doAction();
    }

    public void init(){
//        jTextArea.setEditable(false);
        jTextArea.setLineWrap(true);
        jTextArea.setForeground(new Color(250,250,250));
        jTextArea.setBackground(new Color(0,0,0));
        jTextArea.setFont(new Font("Monospaced", Font.BOLD, 15));
//        jTextArea.setText("Admin@Admin-PC MINGW64 /c/Windows/system32\n$ ");

//        jPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));

        jTextArea.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        jPanel_jTextArea.add(jScrollPane,BorderLayout.CENTER);
        jPanel.add(jPanel_jTextArea, BorderLayout.CENTER);
        this.add(jPanel);
    }

    public void doAction(){
//        this.jTextArea.addKeyListener(new TerminalController(this));
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            TerminalView terminalView = new TerminalView();
            terminalView.setVisible(true);
        });
    }

}
