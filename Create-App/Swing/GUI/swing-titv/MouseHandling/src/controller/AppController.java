package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import model.AppModel;
import view.AppGui;

public class AppController implements ActionListener, MouseListener, MouseMotionListener {

  private AppGui appGui;

  public AppController(AppGui appGui) {
    this.appGui = appGui;
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    appGui.setXLocation(e.getX());
    appGui.setYLocation(e.getY());
    appGui.countClick();
  }

  @Override
  public void mousePressed(MouseEvent e) {

  }

  @Override
  public void mouseReleased(MouseEvent e) {

  }

  @Override
  public void mouseEntered(MouseEvent e) {
    appGui.setInside(true);
  }

  @Override
  public void mouseExited(MouseEvent e) {
    appGui.setInside(false);
  }

  @Override
  public void actionPerformed(ActionEvent e) {

  }

  @Override
  public void mouseDragged(MouseEvent e) {

  }

  @Override
  public void mouseMoved(MouseEvent e) {

  }
}
