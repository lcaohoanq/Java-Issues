package com.lcaohoanq;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
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

    private JPanel jPanel = new JPanel(new GridLayout(3, 1));
    private JLabel jLabel = new JLabel("Think a number between 1 and 10", JLabel.CENTER);
    private JTextField jTextField = new JTextField();
    private JButton jButton = new JButton("Read my mind");
    public URL iconURL = Main.class.getResource("/logo.png");
    public Image icon = Toolkit.getDefaultToolkit().createImage(iconURL);
    private JFrame jFrameProgressBar = new JFrame();
    private JPanel jPanelProgressBar = new JPanel(new GridLayout(2, 1));
    private JLabel jLabelProgress = new JLabel("", JLabel.CENTER);
    private JProgressBar jProgressBar = new JProgressBar(0, 100);
    AudioHandler audioHandler = new AudioHandler();
    int count = 0;

    public Main() {
        this.setTitle("Mind Reader");
        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setIconImage(icon);
        this.setResizable(false);
        initPanelButton();
        initPanelProgressBar();
    }

    private void initPanelProgressBar() {
        Border border = BorderFactory.createEmptyBorder(10, 20, 10, 20);
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
        jLabel.setFont(new Font("Arial", Font.BOLD, 15));
        jTextField.setFont(new Font("Arial", Font.PLAIN, 20));
        jTextField.setHorizontalAlignment(JTextField.CENTER);
        jButton.addActionListener(this);
        jPanel.add(jLabel);
        jPanel.add(jTextField);
        jPanel.add(jButton);
        jPanel.setBorder(border);
        this.add(jPanel);
    }

    public static void main(String[] args) {
        new Main().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!this.jTextField.getText().isEmpty() && (Integer.parseInt(jTextField.getText()) >= 1
            && Integer.parseInt(jTextField.getText()) <= 10)) {
            jFrameProgressBar.setVisible(true);
            audioHandler.playAudio();
            SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                @Override
                protected Void doInBackground() throws Exception {
                    for (int i = 0; i <= 100; i++) {
                        jProgressBar.setValue(i);
                        if (i == 25) {
                            jLabelProgress.setText("Analyzing brainwaves...");
                        } else if (i == 50) {
                            jLabelProgress.setText("Scanning memories...");
                        } else if (i == 75) {
                            jLabelProgress.setText("Calculation probabilities...");
                        } else if (i == 100) {
                            jLabelProgress.setText("Decoding thoughts...");
                        }
                        Thread.sleep(50); // Simulate loading time
                    }
                    return null;
                }

                @Override
                protected void done() {
                    JOptionPane.showMessageDialog(null,
                        "You are thinking about the number " + jTextField.getText(), "Mind Reader",
                        JOptionPane.INFORMATION_MESSAGE);
                    jTextField.setText("");
                    jFrameProgressBar.setVisible(false);
                }
            };
            worker.execute();
        } else {
            audioHandler.playAudio("/error.wav");
            JOptionPane.showMessageDialog(null, "Please enter a number between 1 and 10", "Mind Reader", JOptionPane.ERROR_MESSAGE);
        }


    }
}