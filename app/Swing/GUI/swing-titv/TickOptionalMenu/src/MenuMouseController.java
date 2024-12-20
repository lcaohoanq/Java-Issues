import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuMouseController implements MouseListener {

  private MenuView menuView;

  public MenuMouseController(MenuView menuView) {
    this.menuView = menuView;
  }

  @Override
  public void mouseClicked(MouseEvent e) {

  }

  @Override
  public void mousePressed(MouseEvent e) {
    //SwingUtilities.isRightMouseButton(e)
    if(e.isPopupTrigger()){
      menuView.jPopupMenu.show(e.getComponent(), e.getX(), e.getY());
    }
  }

  @Override
  public void mouseReleased(MouseEvent e) {
//    if(e.isPopupTrigger()){
//      menuView.jPopupMenu.show(e.getComponent(), e.getX(), e.getY());
//    }
  }

  @Override
  public void mouseEntered(MouseEvent e) {

  }

  @Override
  public void mouseExited(MouseEvent e) {

  }
}
