import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DemoGL {

  public DemoGL() {
    JFrame frame = new JFrame();
    //JPanel panel = new JPanel(new GridLayout()); //default: 1 row, 1 column
    //JPanel panel = new JPanel(new GridLayout(1, 2));
    JPanel panel = new JPanel(new GridLayout(2, 2, 10, 3));

    JButton btn1 = new JButton("Button 1");
    JButton btn2 = new JButton("Button 2");
    JButton btn3 = new JButton("Button 3");
    JButton btn4 = new JButton("Button 4");

    panel.add(btn1);
    panel.add(btn2);
    panel.add(btn3);
    panel.add(btn4);

    frame.add(panel);

    frame.setTitle("Grid Layout");
    frame.setSize(400, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    new DemoGL();
  }
}
