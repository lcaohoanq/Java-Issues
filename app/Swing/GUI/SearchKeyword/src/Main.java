import javax.swing.JFrame;

public class Main extends JFrame {

  public Main(){
      initApp();
    }

    private void initApp(){
      add(new MainView());
      setTitle("Search Keyword");
      setLocationRelativeTo(null);
//      setSize(350,230);
    pack()  ;
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}