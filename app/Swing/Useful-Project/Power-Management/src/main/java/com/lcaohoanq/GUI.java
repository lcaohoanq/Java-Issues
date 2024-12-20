package com.lcaohoanq;

import com.lcaohoanq.mode.WindowsShutdown;
import com.lcaohoanq.mode.WindowsSleep;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
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

public class GUI extends JFrame implements ActionListener {

    private JPanel jPanel = new JPanel(new GridLayout(3, 1));
    private JLabel jLabel = new JLabel("Enter the time schedule to...", JLabel.CENTER);
    private JTextField jTextField = new JTextField();
    private JPanel jPanelBottom = new JPanel(new GridLayout(1, 4));
    private JButton jButtonShutdown = new JButton("Shutdown");
    private JButton jButtonRestart = new JButton("Restart");
    private JButton jButtonSleep = new JButton("Sleep");
    private JButton jButtonHibernate = new JButton("Hibernate");
    public URL iconURL = GUI.class.getResource("/logo.png");
    public Image icon = Toolkit.getDefaultToolkit().createImage(iconURL);
    private JFrame jFrameProgressBar = new JFrame();
    private JPanel jPanelProgressBar = new JPanel(new GridLayout(2, 1));
    private JLabel jLabelProgress = new JLabel("", JLabel.CENTER);
    private JProgressBar jProgressBar = new JProgressBar(0, 100);
    AudioHandler audioHandler = new AudioHandler();
    private int result;
    private String userChoice;
    private String timeSchedule;

    public GUI() {
        this.setTitle("Power Management");
        this.setSize(500, 200);
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
        jFrameProgressBar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        jLabel.setFont(new Font("Roboto", Font.BOLD, 15));
        jTextField.setFont(new Font("Roboto", Font.PLAIN, 20));
        jTextField.setHorizontalAlignment(JTextField.CENTER);
        jPanel.add(jLabel);
        jPanel.add(jTextField);

        jButtonShutdown.setBackground(Color.RED);
        jButtonShutdown.setForeground(Color.WHITE);
        jButtonShutdown.setFont(new Font("Roboto", Font.BOLD, 15));

        jButtonRestart.setBackground(Color.YELLOW);
        jButtonRestart.setForeground(Color.BLACK);
        jButtonRestart.setFont(new Font("Roboto", Font.BOLD, 15));

        jButtonSleep.setBackground(Color.BLUE);
        jButtonSleep.setForeground(Color.WHITE);
        jButtonSleep.setFont(new Font("Roboto", Font.BOLD, 15));

        jButtonHibernate.setBackground(Color.GREEN);
        jButtonHibernate.setForeground(Color.WHITE);
        jButtonHibernate.setFont(new Font("Roboto", Font.BOLD, 15));

        jPanelBottom.add(jButtonShutdown);
        jPanelBottom.add(jButtonRestart);
        jPanelBottom.add(jButtonSleep);
        jPanelBottom.add(jButtonHibernate);

        List<JButton> buttons = List.of(jButtonShutdown, jButtonRestart, jButtonSleep,
            jButtonHibernate);
        buttons.stream().forEach(button -> button.addActionListener(this::actionPerformed));

        jPanel.add(jPanelBottom);
        jPanel.setBorder(border);
        this.add(jPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        userChoice = e.getActionCommand();
        timeSchedule = this.jTextField.getText();

        if (timeSchedule.isEmpty() || timeSchedule.equals("0")) {
            //show the progress bar
            result = JOptionPane.showConfirmDialog(null, "Are you sure to continue to " + e.getActionCommand() + " immediately ?", "Power Management", JOptionPane.YES_NO_OPTION);
            if(result == JOptionPane.YES_OPTION){
                jFrameProgressBar.setVisible(true);
                audioHandler.playAudio();
                SwingWorker<Void, Void> worker = new SwingWorker<>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        for (int i = 0; i <= 100; i++) {
                            jProgressBar.setValue(i);
                            if (i == 25) {
                                jLabelProgress.setText("Loading.");
                            } else if (i == 50) {
                                jLabelProgress.setText("Loading..");
                            } else if (i == 75) {
                                jLabelProgress.setText("Loading...");
                            } else if (i == 100) {
                                jLabelProgress.setText("Loading.... Done!");
                            }
                            Thread.sleep(50); // Simulate loading time
                        }
                        return null;
                    }

                    @Override
                    protected void done() {
                        //do action immediately
                        switch (userChoice) {
                            case "Shutdown":
                                WindowsShutdown.shutdown();
                                break;
                            case "Restart":
                                System.out.println("Restart 0s");
                                break;
                            case "Sleep":
                                WindowsSleep.sleep();
                                break;
                            case "Hibernate":
                                System.out.println("Hibernate 0s");
                                break;
                        }
                    }
                };
                worker.execute();
            }
        } else if (Integer.parseInt(timeSchedule) > 0) {
            result = JOptionPane.showConfirmDialog(null, "Are you sure to continue to " + e.getActionCommand() + " in " + timeSchedule + " seconds?", "Power Management", JOptionPane.YES_NO_OPTION);
            if(result == JOptionPane.YES_OPTION){
                //do action with the time specify
                switch (userChoice) {
                    case "Shutdown":
                        System.out.println("Shutdown xs");
                        break;
                    case "Restart":
                        System.out.println("Restart xs");
                        break;
                    case "Sleep":
                        System.out.println("Sleep xs");
                        break;
                    case "Hibernate":
                        System.out.println("Hibernate xs");
                        break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a number greater or equals than 0",
                "Power Management", JOptionPane.ERROR_MESSAGE);
        }
    }
}