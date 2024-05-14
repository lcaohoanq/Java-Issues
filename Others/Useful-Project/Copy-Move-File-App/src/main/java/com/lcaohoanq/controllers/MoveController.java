package com.lcaohoanq.controllers;

import com.lcaohoanq.views.MoveFrame;
import com.lcaohoanq.views.ProgressBarFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.JOptionPane;

public class MoveController implements ActionListener {
    private MoveFrame moveFrame;

    public MoveController(MoveFrame moveFrame){
        this.moveFrame = moveFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("You are in the Move Action");

        File sourceFile = moveFrame.getFile();
        String destinationPath = moveFrame.getFolderPath();

        if(!moveFrame.checkState()){
            ProgressBarFrame progressBarFrame = new ProgressBarFrame();
            progressBarFrame.setVisible(true);
            progressBarFrame.triggerAction();

            // Check if source file and destination path are not null
            if (sourceFile != null && destinationPath != null) {
                try {
                    // Create a Path for the destination file
                    Path destinationFile = Paths.get(destinationPath, sourceFile.getName());

                    // Use Files.move() method to move the file
                    Files.move(sourceFile.toPath(), destinationFile, StandardCopyOption.REPLACE_EXISTING);

                    System.out.println("File moved successfully to " + destinationFile);
                    JOptionPane.showMessageDialog(moveFrame, "File moved successfully to " + destinationFile, "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    System.out.println("Error moving file: " + ex.getMessage());
                }
            } else {
                System.out.println("Source file or destination path is null");
                JOptionPane.showMessageDialog(moveFrame, "Please select a file and destination folder to move", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(moveFrame, "Please select a file to process", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
}
