import java.awt.*;
import javax.swing.*;

public class DemoExtendsJFrame extends JFrame {

  public DemoExtendsJFrame() {
    this.setTitle("Demo Extends JFrame");
    this.setSize(400, 400);

    //căn giữa màn hình
    this.setLocationRelativeTo(null);

    //tạo 1 layout
    FlowLayout flowLayout = new FlowLayout();

    GridLayout gridLayout_1 = new GridLayout();
    GridLayout gridLayout_2 = new GridLayout(4, 4);
    //tại sao 4 x 4 mà hiển thị bằng 4 x 3?
    //
    GridLayout gridLayout_3 = new GridLayout(4, 4, 25, 25);

    //set layout cho JFrame
    this.setLayout(gridLayout_3);

    for (int i = 0; i < 16; i++) {
      JButton btn = new JButton(i + "");
      this.add(btn);
    }

//    this.add(new JButton("btn1"));
//    this.add(new JButton("btn2"));

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }

  public static void main(String[] args) {
    new DemoExtendsJFrame();
  }
}
