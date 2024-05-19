package com.lcaohoanq;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.border.Border;

public class Main extends JFrame implements ActionListener {

    private JPanel jPanel = new JPanel(new BorderLayout());
    private JButton jButton = new JButton("Optimize my computer");
    public URL iconURL = Main.class.getResource("/logo.png");
    public Image icon = Toolkit.getDefaultToolkit().createImage(iconURL);
    private JFrame jFrameProgressBar = new JFrame();
    private JPanel jPanelProgressBar = new JPanel(new GridLayout(2, 1));
    private JLabel jLabelProgress = new JLabel("", JLabel.CENTER);
    private JProgressBar jProgressBar = new JProgressBar(0, 100);
    AudioHandler audioHandler = new AudioHandler();

    public Main() {
        this.setTitle("Windows Tweaker");
        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setIconImage(icon);
        this.setResizable(false);
        initPanelButton();
        initPanelProgressBar();
    }

    private void initPanelProgressBar() {
        Border border = BorderFactory.createEmptyBorder(50, 30, 50, 30);
        jFrameProgressBar.setTitle("Loading...");
        jFrameProgressBar.setIconImage(icon);
        jFrameProgressBar.setSize(250, 100);
        jFrameProgressBar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrameProgressBar.setResizable(false);
        jFrameProgressBar.setLocationRelativeTo(null);
        jFrameProgressBar.setVisible(false);
        jFrameProgressBar.add(jPanelProgressBar);

        jPanelProgressBar.add(jLabelProgress);
        jPanelProgressBar.add(jProgressBar);
        jPanel.setBorder(border);
    }

    private void initPanelButton() {
        Border border = BorderFactory.createEmptyBorder(10, 20, 10, 20);
        jButton.setBackground(Color.decode("#19b719"));
        jButton.setFont(new Font("Arial", Font.BOLD, 16));
        jButton.setForeground(Color.WHITE);
        jButton.addActionListener(this);
        jPanel.add(jButton, BorderLayout.CENTER);
        jPanel.setBorder(border);
        this.add(jPanel);
    }

    public static void main(String[] args) {
        new Main().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jFrameProgressBar.setVisible(true);
        audioHandler.playAudio();
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (int i = 0; i <= 100; i++) {
                    jProgressBar.setValue(i);
                    if (i == 20) {
                        jLabelProgress.setText("Identifying unnecessary files...");
                    } else if (i == 40) {
                        jLabelProgress.setText("Preparing for cleanup...");
                    } else if (i == 60) {
                        jLabelProgress.setText("Cleaning the garbage...");
                    } else if (i == 80) {
                        jLabelProgress.setText("Finalizing cleanup...");
                    } else if (i == 100) {
                        jLabelProgress.setText("Cleanup completed...");
                    }
                    Thread.sleep(297);
                }
                return null;
            }

            @Override
            protected void done() {
                JOptionPane.showMessageDialog(null,
                    "Done, your PC now is on the fly!!!!!", "Enjoy your new PC!",
                    JOptionPane.INFORMATION_MESSAGE);
                jFrameProgressBar.setVisible(false);
                WindowsDesktopBackground.setDesktopBackgroundAsStream("/image.jpg");
                try {
                    // Specify the URL of the website
                    URI uri = new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley");
                    // Open the website in the default browser
                    if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                        Desktop.getDesktop().browse(uri);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
        worker.execute();
    }
}