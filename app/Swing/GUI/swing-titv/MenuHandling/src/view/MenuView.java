package view;

import controller.MenuController;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MenuView extends JFrame {
  JLabel label;
  Font font = new Font("Verdana", Font.BOLD, 20);

  public MenuView() {
    initMenu();
  }

  private void initMenu() {
    JPanel panel = new JPanel(new BorderLayout());
    JMenuBar menuBar = new JMenuBar();
    menuBar.setLocation(0, 0);
    JMenu menuFile = new JMenu("File");
    JMenu menuHelp = new JMenu("Help");

    JMenuItem menuOpen = new JMenuItem("Open");
    JMenuItem menuExit = new JMenuItem("Exit");
    menuFile.add(menuOpen);
    menuFile.add(menuExit);

    JMenuItem menuAboutMe = new JMenuItem("About Me");
    menuHelp.add(menuAboutMe);
    menuBar.add(menuFile);
    menuBar.add(menuHelp);

    label = new JLabel("You choose:");
    label.setFont(font);

    ActionListener ac = new MenuController(this);
    menuOpen.addActionListener(ac);
    menuExit.addActionListener(ac);
    menuAboutMe.addActionListener(ac);

    panel.add(menuBar, BorderLayout.NORTH);
    panel.add(label, BorderLayout.CENTER);

    this.add(panel);
    this.setTitle("Menu");
    this.setSize(800, 600);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setVisible(true);
  }

  public void clickOpen() {
    label.setText("You choose: Open");
  }

  public void clickExit() {
    System.exit(0);
  }

  public void clickAboutMe() {
    label.setText("You choose: AboutMe");
  }

}
