package com.lcaohoanq.controllers;

import com.lcaohoanq.views.CopyFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.JOptionPane;

public class CopyController implements ActionListener {
    private CopyFrame copyFrame;

    public CopyController(CopyFrame copyFrame){
        this.copyFrame = copyFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("You are in the Copy Action");

        File sourceFile = copyFrame.getFile();
        String destinationPath = copyFrame.getFolderPath();

        if(!copyFrame.checkState()){
//            CountDownLatch latch = new CountDownLatch(1);
//
//            new Thread(() -> {
//                ProgressBarFrame progressBarFrame = new ProgressBarFrame();
//                progressBarFrame.setVisible(true);
//                progressBarFrame.triggerAction();
//                latch.countDown();  // Decrements the count of the latch, releasing all waiting threads when the count reaches zero
//            }).start();
//
//            try {
//                latch.await();  // Causes the current thread to wait until the latch has counted down to zero
//            } catch (InterruptedException ex) {
//                ex.printStackTrace();
//            }

            // Check if source file and destination path are not null
            if (sourceFile != null && destinationPath != null) {
                try {
                    // Create a Path for the destination file
                    Path destinationFile = Paths.get(destinationPath, sourceFile.getName());

                    // Use Files.copy() method to copy the file
                    Files.copy(sourceFile.toPath(), destinationFile, StandardCopyOption.REPLACE_EXISTING);

                    System.out.println("File copied successfully to " + destinationFile);
                    JOptionPane.showMessageDialog(copyFrame, "File copied successfully to " + destinationFile, "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    System.out.println("Error copying file: " + ex.getMessage());
                }
            } else {
                System.out.println("Source file or destination path is null");
                JOptionPane.showMessageDialog(copyFrame, "Please select a file and destination folder to copy", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(copyFrame, "Please select a file to process", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
