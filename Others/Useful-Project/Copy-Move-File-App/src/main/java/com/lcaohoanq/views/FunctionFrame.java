package com.lcaohoanq.views;

import com.lcaohoanq.controllers.FunctionController;
import com.lcaohoanq.utils.FileHandler;
import com.lcaohoanq.utils.ImageHandler;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public abstract class FunctionFrame extends JFrame {
    private JFileChooser sourceFileChooser;
    private JFileChooser destinationFileChooser;
    private JPanel topPanel;
    private JScrollPane middlePanel;
    private JPanel bottomPanel;
    private JTextArea fileInfoArea;
    private JButton processButton;
    protected JButton copyButton;
    protected JButton moveButton;
    protected File selectedFile;

    public FunctionFrame(){
        this.setSize(1000, 600);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageHandler().icon);
        this.setVisible(false);

        initUI();
    }

    private void initUI(){
        initTop();
        initMiddle();
        initBottom();
        initContainer();
        doAction();
    }

    private void initTop(){
        topPanel = new JPanel(new GridLayout(1, 2));
        sourceFileChooser = new JFileChooser();
        destinationFileChooser = new JFileChooser();
        topPanel.add(sourceFileChooser);
        topPanel.add(destinationFileChooser);
    }

    private void initMiddle(){
        fileInfoArea = new JTextArea();
        fileInfoArea.setFont(new Font("Roboto", Font.PLAIN, 20));
        middlePanel = new JScrollPane(fileInfoArea);
    }

    private void initBottom(){
        bottomPanel = new JPanel();
        processButton = new JButton("Process");
        processButton.setPreferredSize(new Dimension(300, 50));
        processButton.setFont(new Font("Roboto", Font.BOLD, 20));

        bottomPanel.add(processButton);
    }

    private void initContainer(){
        this.add(topPanel, BorderLayout.NORTH);
        this.add(middlePanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
    }

    private void viewFileData(){
        sourceFileChooser.addActionListener(e -> {
            fileInfoArea.setText("");
            if (e.getActionCommand().equals(JFileChooser.APPROVE_SELECTION)) {
                selectedFile = sourceFileChooser.getSelectedFile();
                fileInfoArea.append("Name: " + selectedFile.getName() + "\n");
                fileInfoArea.append("Path: " + selectedFile.getAbsolutePath() + "\n");
                fileInfoArea.append("Size: " + selectedFile.length() + " Bytes\n");
                fileInfoArea.append("Type: " + FileHandler.getFileExtension(selectedFile) + "\n");
            }
        });
    }

    protected void doAction(){
        viewFileData();
        processButton.addActionListener(new FunctionController(this));
    };
}
