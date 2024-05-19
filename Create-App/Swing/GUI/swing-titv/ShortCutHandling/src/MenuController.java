import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController implements ActionListener {

  private MenuView menuView;

  public MenuController(MenuView menuView){
    this.menuView = menuView;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getActionCommand().equals("New")){
      menuView.clickNew();
    }
    else if(e.getActionCommand().equals("Open")){
      menuView.clickOpen();
    }else if(e.getActionCommand().equals("Exit")){
      menuView.clickExit();
    }else if(e.getActionCommand().equals("About Me")){
      menuView.clickAboutMe();
    }
  }
}
