import javax.swing.JFrame;

public class DrawExampleView extends JFrame {
  public DrawExampleView() {
    add(new JPanelDraw());
    this.setTitle("Draw Example");
    this.setSize(300, 300);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.add(new JPanelDraw());
    this.setVisible(true);
  }

  public static void main(String[] args) {
    new DrawExampleView();
  }
}
