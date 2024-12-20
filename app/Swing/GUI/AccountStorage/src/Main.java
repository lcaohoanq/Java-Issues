import javax.swing.JFrame;

public class Main extends JFrame {
  public Main() {
    add(new AccountView());
    setTitle("Account Storage");
    pack();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);
  }

  public static void main(String[] args) {
//    try {
//      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//      new Main();
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
    new Main();
  }
}