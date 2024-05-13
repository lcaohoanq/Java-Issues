package com.lcaohoanq.views;

import com.lcaohoanq.utils.AudioHandler;
import com.lcaohoanq.utils.ImageHandler;
import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import javax.swing.border.Border;

public class ProgressBarFrame extends JFrame implements ActionListener {

    private JPanel jPanelProgressBar = new JPanel(new GridLayout(2, 1));
    private JLabel jLabelProgress = new JLabel("", JLabel.CENTER);
    private JProgressBar jProgressBar = new JProgressBar(0, 100);
    AudioHandler audioHandler = new AudioHandler();
    public ProgressBarFrame(){
        this.setTitle("Loading...");
        this.setIconImage(new ImageHandler().icon);
        this.setSize(250, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        initPanelProgressBar();
    }

    private void initPanelProgressBar() {
        Border border = BorderFactory.createEmptyBorder(10, 30, 10, 30);
        jPanelProgressBar.add(jLabelProgress);
        jPanelProgressBar.add(jProgressBar);
        jPanelProgressBar.setBorder(border);
        this.add(jPanelProgressBar);
    }

    public void triggerAction() {
        this.actionPerformed(null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
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
                ProgressBarFrame.this.setVisible(false);
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
