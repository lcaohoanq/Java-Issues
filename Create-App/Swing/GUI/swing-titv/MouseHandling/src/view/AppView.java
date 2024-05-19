package view;

import javax.swing.JFrame;
import model.AppModel;

public class AppView extends JFrame {


  public AppView(){

    initApp();
  }
  private void initApp() {
    add(new AppGui());
    setTitle("Mouse Handling");
    pack();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);
  }

}
