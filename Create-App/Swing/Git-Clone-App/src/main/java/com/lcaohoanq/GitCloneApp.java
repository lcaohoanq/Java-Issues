package com.lcaohoanq;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import java.io.File;

public class GitCloneApp {

    private static AudioHandler audioHandler = new AudioHandler();

    public static void main(String[] args) {
        // Initialize "cloned_repo" folder if it doesn't exist
        File clonedRepoDir = new File("cloned_repo");
        if (!clonedRepoDir.exists()) {
            if (!clonedRepoDir.mkdir()) {
                System.err.println("Failed to create 'cloned_repo' directory.");
                System.exit(1);
            }
        }

        JFrame frame = new JFrame("Git Clone App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 250);

        Container container = frame.getContentPane();
        container.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextField repoUrlField = new JTextField();
        JButton cloneButton = new JButton("Clone");

        panel.add(repoUrlField, BorderLayout.CENTER);
        panel.add(cloneButton, BorderLayout.EAST);

        JTextArea statusArea = new JTextArea();
        statusArea.setEditable(false);

        container.add(panel, BorderLayout.NORTH);
        container.add(new JScrollPane(statusArea), BorderLayout.CENTER);

        cloneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String repoUrl = repoUrlField.getText();
                if (repoUrl.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter a repository URL");
                } else {
                    String folderRepoName = repoUrl.substring(repoUrl.lastIndexOf("/") + 1,
                        repoUrl.length());
                    statusArea.setText("Cloning repository...\n");
                    cloneButton.setEnabled(false); // Disable the clone button during cloning

                    new Thread(() -> {
                        try {
                            // Create a unique directory for each cloned repository
                            File repoDir = new File(clonedRepoDir, folderRepoName);
                            Git.cloneRepository()
                                .setURI(repoUrl)
                                .setDirectory(repoDir)
                                .call();
                            statusArea.append("Repository cloned successfully.\n");

                            audioHandler.playAudio("/ding.wav");
                            JOptionPane.showMessageDialog(frame, "Repository cloned successfully!");
                        } catch (GitAPIException ex) {
                            statusArea.append("Error: " + ex.getMessage() + "\n");
                            audioHandler.playAudio("/error.wav");
                        } catch (Exception ex) {
                            statusArea.append("Unexpected error: " + ex.getMessage() + "\n");
                            audioHandler.playAudio("/error.wav");
                        } finally {
                            cloneButton.setEnabled(
                                true); // Re-enable the clone button after cloning
                        }
                    }).start();
                }
            }
        });

        frame.setVisible(true);
    }
}

