import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class MenuView extends JFrame {
  JLabel label;
  Font font = new Font("Verdana", Font.BOLD, 20);
  public MenuView(){
    initMenu();
  }

  private void initMenu(){
    JPanel panel = new JPanel(new BorderLayout());
    JMenuBar menuBar = new JMenuBar();
    menuBar.setLocation(0, 0);
    JMenu menuFile = new JMenu("File");
    JMenu menuHelp = new JMenu("Help");

    JMenuItem menuNew = new JMenuItem("New", KeyEvent.VK_N);
    menuNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK)); // CTRL + N
    JMenuItem menuOpen = new JMenuItem("Open", KeyEvent.VK_O);
    menuOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK)); // CTRL + O
    JMenuItem menuExit = new JMenuItem("Exit", KeyEvent.VK_X);
    menuExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK)); //CTRL + X
    menuFile.add(menuNew);
    menuFile.add(menuOpen);
    menuFile.add(menuExit);

    JMenuItem menuAboutMe = new JMenuItem("About Me");
    menuHelp.add(menuAboutMe);
    menuBar.add(menuFile);
    menuBar.add(menuHelp);

    label = new JLabel("You choose:");
    label.setFont(font);

    ActionListener ac = new MenuController(this);
    menuNew.addActionListener(ac);
    menuOpen.addActionListener(ac);
    menuExit.addActionListener(ac);
    menuAboutMe.addActionListener(ac);


    panel.add(menuBar, BorderLayout.NORTH);
    panel.add(label,BorderLayout.CENTER);


    this.add(panel);
    this.setTitle("Menu");
    this.setSize(800, 600);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setVisible(true);
  }
  public void clickNew(){
    label.setText("You choose: New");
  }

  public void clickOpen(){
    label.setText("You choose: Open");
  }
  public void clickExit(){
    System.exit(0);
  }
  public void clickAboutMe(){
    label.setText("You choose: AboutMe");
  }


}
