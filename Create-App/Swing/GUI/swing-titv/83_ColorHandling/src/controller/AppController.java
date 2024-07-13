package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import view.Gui;

public class AppController implements ActionListener {
  public Gui gui;

  public AppController(Gui gui) {
    this.gui = gui;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    JButton btn = (JButton) e.getSource();
    if (btn.getBackground().equals(Color.RED)) {
      // gui.setTextColor("RED");
      gui.setTextColor(Color.RED);
    } else if (btn.getBackground().equals(Color.YELLOW)) {
      // gui.setTextColor("YELLOW");
      gui.setTextColor(Color.YELLOW);
    } else if (btn.getBackground().equals(Color.GREEN)) {
      // gui.setTextColor("GREEN");
      gui.setTextColor(Color.GREEN);
    } else if (btn.getBackground().equals(Color.BLUE)) {
      // gui.setBackGroundColor("BLUE");
      gui.setBackGroundColor(Color.BLUE);
    } else if (btn.getBackground().equals(Color.ORANGE)) {
      // gui.setBackGroundColor("ORANGE");
      gui.setBackGroundColor(Color.ORANGE);
    } else {
      // back ground pink
      // gui.setBackGroundColor("PINK");
      gui.setBackGroundColor(Color.PINK);
    }
  }
}
