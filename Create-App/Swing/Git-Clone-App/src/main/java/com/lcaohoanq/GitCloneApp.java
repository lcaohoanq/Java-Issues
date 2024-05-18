package com.lcaohoanq;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import java.io.File;

public class GitCloneApp extends JFrame implements ActionListener, KeyListener {

    private static AudioHandler audioHandler = new AudioHandler();
    private URL iconURL = GitCloneApp.class.getResource("/logo.png");
    public Image icon = Toolkit.getDefaultToolkit().createImage(iconURL);
    private JPanel panel = new JPanel();
    private JTextField repoUrlField = new JTextField();
    private JButton cloneButton = new JButton("Clone");
    private JTextArea statusArea = new JTextArea();
    private File clonedRepoDir;

    public GitCloneApp() {
        setTitle("Git Clone App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 250);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setIconImage(icon);
        setVisible(false);
        initDirectory("cloned_repo");
        initUI();
    }

    private void initUI() {
        cloneButton.setBackground(Color.decode("#F27BBD"));
        cloneButton.setForeground(Color.WHITE);
        cloneButton.setFont(new Font("Arial", Font.BOLD, 14));
        cloneButton.addActionListener(this);

        repoUrlField.addKeyListener(this);

        statusArea.setEditable(false);
        statusArea.setLineWrap(true);

        panel.setLayout(new BorderLayout());
        panel.add(repoUrlField, BorderLayout.CENTER);
        panel.add(cloneButton, BorderLayout.EAST);
        this.add(panel, BorderLayout.NORTH);
        this.add(new JScrollPane(statusArea), BorderLayout.CENTER);
    }

    private void initDirectory(String name) {
        clonedRepoDir = new File(name);
        if (!clonedRepoDir.exists()) {
            if (!clonedRepoDir.mkdir()) {
                System.err.println("Failed to create " + name + " directory.");
                System.exit(1);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String repoUrl = repoUrlField.getText();
        if (repoUrl.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a repository URL");
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
                    JOptionPane.showMessageDialog(null, "Repository cloned successfully!");
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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == KeyEvent.VK_ENTER) {
            this.actionPerformed(null);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

