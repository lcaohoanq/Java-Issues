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

    private static final AudioHandler audioHandler = new AudioHandler();
    private final URL iconURL = GitCloneApp.class.getResource("/logo.png");
    public Image icon = Toolkit.getDefaultToolkit().createImage(iconURL);
    private final JPanel jPanel = new JPanel();
    private final JTextField jTextField_RepoUrl = new JTextField();
    private final JButton jButton_CloneButton = new JButton("Clone");
    private final JTextArea jTextArea_StatusArea = new JTextArea();
    private JFileChooser jFileChooser;
    private Timer timer;
    private String repoUrl;
    private String folderRepoName;
    private File selectedDirectory;

    public GitCloneApp() {
        setTitle("Git Clone App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 250);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setIconImage(icon);
        setVisible(false);
        initFileChooser();
        initUI();
    }

    private void initUI() {
        jButton_CloneButton.setBackground(Color.decode("#F27BBD"));
        jButton_CloneButton.setForeground(Color.WHITE);
        jButton_CloneButton.setFont(new Font("Arial", Font.BOLD, 14));
        jButton_CloneButton.addActionListener(this);

        jTextField_RepoUrl.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextField_RepoUrl.addKeyListener(this);

        jTextArea_StatusArea.setBackground(Color.decode("#121212"));
        jTextArea_StatusArea.setForeground(Color.decode("#16FF00"));
        jTextArea_StatusArea.setFont(new Font("Roboto", Font.PLAIN, 14));
        jTextArea_StatusArea.setEditable(false);
        jTextArea_StatusArea.setLineWrap(true);

        jPanel.setLayout(new BorderLayout());
        jPanel.add(jTextField_RepoUrl, BorderLayout.CENTER);
        jPanel.add(jButton_CloneButton, BorderLayout.EAST);
        this.add(jPanel, BorderLayout.NORTH);
        this.add(new JScrollPane(jTextArea_StatusArea), BorderLayout.CENTER);
    }

    private void initFileChooser() {
        jFileChooser = new JFileChooser();
        jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repoUrl = jTextField_RepoUrl.getText();
        if (!validateRepoUrl(repoUrl)) {
            return;
        }

        selectedDirectory = selectDirectory();
        if (selectedDirectory == null) {
            return;
        }

        folderRepoName = repoUrl.substring(repoUrl.lastIndexOf("/") + 1);

        timer = startLoadingEffect();

        new Thread(() -> {
            cloneRepository(repoUrl, folderRepoName);
        }).start();
    }

    private boolean validateRepoUrl(String repoUrl) {
        if (repoUrl.isEmpty()) {
            audioHandler.playAudio("/error.wav");
            JOptionPane.showMessageDialog(null, "Please enter a repository URL");
            return false;
        } else {
            //check if the url is match with github url
            if (repoUrl.matches("^https:\\/\\/github\\.com\\/[\\w-]+\\/[\\w(\\-|\\s|\\_|.)]+$")) {
                return true;
            }else{
                audioHandler.playAudio("/error.wav");
                JOptionPane.showMessageDialog(null, "Please enter a valid GitHub repository URL");
                return false;
            }
        }
    }

    private File selectDirectory() {
        Object[] customizeOptions = {"Select", "Desktop"};
        int userChoice = JOptionPane.showOptionDialog(null,
            "Choose the selected directory or placed in your Desktop?", "Confirm",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, customizeOptions,
            customizeOptions[1]);
        if (userChoice == JOptionPane.YES_OPTION) {
            int option = jFileChooser.showOpenDialog(this);
            if (option == JFileChooser.APPROVE_OPTION) {
                return jFileChooser.getSelectedFile();
            }
        } else {
            // Default to user's Desktop if no directory is selected
            return new File(System.getProperty("user.home"), "Desktop");
        }
        return null;
    }

    private void cloneRepository(String repoUrl, String folderRepoName) {
        try {
            // Create a unique directory for each cloned repository
            File repoDir = new File(selectedDirectory, folderRepoName);
            Git.cloneRepository()
                .setURI(repoUrl)
                .setDirectory(repoDir)
                .call();
            stopLoadingEffect(timer);
            audioHandler.playAudio("/ding.wav");
            JOptionPane.showMessageDialog(null, "Repository cloned successfully!");
        } catch (GitAPIException ex) {
            jTextArea_StatusArea.append("Error: " + ex.getMessage() + "\n");
            audioHandler.playAudio("/error.wav");
        } catch (Exception ex) {
            jTextArea_StatusArea.append("Unexpected error: " + ex.getMessage() + "\n");
            audioHandler.playAudio("/error.wav");
        }
    }

    private Timer startLoadingEffect() {
        jTextArea_StatusArea.setText("Cloning repository");
        jButton_CloneButton.setEnabled(false); // Disable the clone button during cloning

        // Create a timer that appends a dot to the text area every 500 milliseconds
        Timer timer = new Timer(500, null);
        timer.addActionListener(event -> jTextArea_StatusArea.append("."));
        timer.start();

        return timer;
    }

    private void stopLoadingEffect(Timer timer) {
        // Stop the timer and append a newline character when the cloning is done
        timer.stop();
        jButton_CloneButton.setEnabled(true); // Re-enable the clone button after cloning
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
            this.actionPerformed(null);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

