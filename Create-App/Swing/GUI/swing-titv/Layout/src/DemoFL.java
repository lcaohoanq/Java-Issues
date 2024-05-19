import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DemoFL {

  public DemoFL() {
    JFrame frame = new JFrame();
    //FlowLayout() -> Center, horizontal gap = 5, vertical gap = 5
    //FlowLayout(int align) -> Center, Left, Right
    //FlowLayout(int align, int hgap, int vgap)
    JPanel panel = new JPanel(new FlowLayout());
//    JPanel panel = new JPanel(); //như nhau

    JButton btn1 = new JButton("Button 1");
    JButton btn2 = new JButton("Button 2");
    panel.add(btn1,
        BorderLayout.NORTH); //nếu để FlowLayout thì tác động tới những cái khác sẽ không thay đổi
    panel.add(btn2, BorderLayout.SOUTH);

    frame.add(panel);

//    frame.add(new JButton("ShortHand"));
//    frame.add(new JButton("ShortHand2"));

    frame.setTitle("Layout Manager");
    frame.setSize(400, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    new DemoFL();
  }
}