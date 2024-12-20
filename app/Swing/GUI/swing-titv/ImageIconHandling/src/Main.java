import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Main extends JFrame {

  JMenuBar menubar = new JMenuBar();
  JMenu menu, submenu;
  JMenuItem i1, i2, i3, i4, i5;
  JButton jButton;
  JLabel jLabel;

  public Main() {
    setTitle("Image Icon");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(800, 600);
    setLocationRelativeTo(null);
    pack();
    // !Set Icon cho frame
    // ? Lay duong link
    URL iconURL = Main.class.getResource("resources/power-button.png");
    // ? Tao Image
    Image img = Toolkit.getDefaultToolkit().createImage(iconURL);
    // !dua hinh anh vao frame
    this.setIconImage(img);

    // TODO set icon cho cac item trong menu
    // ? Lay duong link
    URL iconURL1 = Main.class.getResource("one.png");
    URL iconURL2 = Main.class.getResource("two.png");
    URL iconURL3 = Main.class.getResource("three.png");
    URL iconURL4 = Main.class.getResource("four.png");
    URL iconURL5 = Main.class.getResource("five.png");
    // ? Tao Image
    Image img1 = Toolkit.getDefaultToolkit().createImage(iconURL1);
    Image img2 = Toolkit.getDefaultToolkit().createImage(iconURL2);
    Image img3 = Toolkit.getDefaultToolkit().createImage(iconURL3);
    Image img4 = Toolkit.getDefaultToolkit().createImage(iconURL4);
    Image img5 = Toolkit.getDefaultToolkit().createImage(iconURL5);

    menu = new JMenu("Menu");
    submenu = new JMenu("Sub Menu");
    i1 = new JMenuItem("Item 1");
    i1.setIcon(new ImageIcon(img1));
    i2 = new JMenuItem("Item 2");
    i2.setIcon(new ImageIcon(img2));
    i3 = new JMenuItem("Item 3");
    i3.setIcon(new ImageIcon(img3));
    i4 = new JMenuItem("Item 4");
    i4.setIcon(new ImageIcon(img4));
    i5 = new JMenuItem("Item 5");
    // ! thong qua IMageIcon
    i5.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Main.class.getResource("five.png"))));
    menu.add(i1);
    menu.add(i2);
    menu.add(i3);
    submenu.add(i4);
    submenu.add(i5);
    menu.add(submenu); // ! xem submenu nhu mot item thoi
    menubar.add(menu);

    this.setJMenuBar(menubar);

    // ? JPanel
    JPanel panel = new JPanel(new BorderLayout());

    // ? JLabel
    jLabel = new JLabel("Day la JLabel");
    jLabel.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Main.class.getResource("test.jpg"))));

    // ? JButton
    jButton = new JButton("Test Button");
    // jButton.setIcon(new
    // ImageIcon(Toolkit.getDefaultToolkit().createImage(Main.class.getResource("power-button.png"))));
    jButton.setFont(new Font("Arial", Font.BOLD, 20));
    jButton.setSize(50, 50);

    this.setJMenuBar(menubar); // ! them menubar vao frame
    panel.add(jLabel, BorderLayout.CENTER);
    panel.add(jButton, BorderLayout.SOUTH);
    this.add(panel);

    setVisible(true);
  }

  public static void main(String[] args) {
    new Main();
  }
}