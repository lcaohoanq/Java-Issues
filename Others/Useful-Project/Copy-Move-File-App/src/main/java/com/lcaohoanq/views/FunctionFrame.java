package com.lcaohoanq;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public abstract class FunctionFrame extends JFrame implements ActionListener {
    private JFileChooser sourceFileChooser = new JFileChooser();
    private JFileChooser destinationFileChooser = new JFileChooser();
    private JTextArea fileInfoArea = new JTextArea();
    private JButton copyButton = new JButton("Copy");

    public FunctionFrame(){
        this.setSize(1000, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageHandler().icon);
        this.setVisible(false);

        JPanel topPanel = new JPanel(new GridLayout(1, 2));
        topPanel.add(sourceFileChooser);
        topPanel.add(destinationFileChooser);

        JScrollPane middlePanel = new JScrollPane(fileInfoArea);

        JPanel bottomPanel = new JPanel();
        copyButton.setPreferredSize(new Dimension(300, 50));
        bottomPanel.add(copyButton);

        this.add(topPanel, BorderLayout.NORTH);
        this.add(middlePanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);

        sourceFileChooser.addActionListener(e -> {
            fileInfoArea.setText("");
            if (e.getActionCommand().equals(JFileChooser.APPROVE_SELECTION)) {
                File selectedFile = sourceFileChooser.getSelectedFile();
                fileInfoArea.append("Name: " + selectedFile.getName() + "\n");
                fileInfoArea.append("Path: " + selectedFile.getAbsolutePath() + "\n");
                fileInfoArea.append("Size: " + selectedFile.length() + " bytes\n");
                fileInfoArea.append("Type: " + getFileExtension(selectedFile) + "\n");
            }
        });

        copyButton.addActionListener(this);
    }

    private String getFileExtension(File file) {
        String fileName = file.getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Play the progress bar
        ProgressBarFrame progressBarFrame = new ProgressBarFrame();
        progressBarFrame.setVisible(true);
        progressBarFrame.triggerAction();

        // Copy the file

    }
}
