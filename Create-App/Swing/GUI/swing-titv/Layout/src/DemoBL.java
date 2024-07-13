import javax.swing.*;
import java.awt.*; //BorderLayout, FlowLayout

public class DemoBL {

  public DemoBL() {
    JFrame frame = new JFrame();
    frame.setTitle("Border Layout");
    frame.setSize(400, 400);
    //không có khoảng cách giữa các thành phầ
    BorderLayout borderLayout = new BorderLayout();
    //có khoảng cách giữa các thành phần
    BorderLayout borderLayout2 = new BorderLayout(10, 10);

    JPanel panel = new JPanel();
    JButton btn1 = new JButton("Button 1");
    JButton btn2 = new JButton("Button 2");
    JButton btn3 = new JButton("Button 3");
    JButton btn4 = new JButton("Button 4");
    JButton btn5 = new JButton("Button 5");

    panel.setLayout(borderLayout2);

    panel.add(btn1, BorderLayout.NORTH);
    panel.add(btn2, BorderLayout.SOUTH);
    panel.add(btn3, BorderLayout.EAST); //Phia Dong
    panel.add(btn4, BorderLayout.WEST); //Phia Tay
    panel.add(btn5, BorderLayout.CENTER);

    frame.add(panel);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    new DemoBL();
  }
}
