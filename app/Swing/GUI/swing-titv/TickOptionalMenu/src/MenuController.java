import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController implements ActionListener {

  private MenuView menuView;

  public MenuController(MenuView menuView) {
    this.menuView = menuView;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String value = e.getActionCommand();
//    if(e.getActionCommand().equals("New")){
//      menuView.clickNew();
//    }
//    else if(e.getActionCommand().equals("Open")){
//      menuView.clickOpen();
//    }else if(e.getActionCommand().equals("Exit")){
//      menuView.clickExit();
//    }else if(e.getActionCommand().equals("About Me")){
//      menuView.clickAboutMe();
//    }
    if (value.equals("File")) {
      menuView.setLabel("You choose: Menu File");
    } else if (value.equals("Help")) {
      menuView.setLabel("You choose: Menu Help");
    } else if(value.equals("New")){
      menuView.setLabel("You choose: Menu Item New");
    } else if(value.equals("Open")){
      menuView.setLabel("You choose: Menu Item Open");
    } else if(value.equals("Exit")){
      menuView.setLabel("You choose: Menu Item Exit");
    } else if(value.equals("About Me")){
      menuView.setLabel("You choose: Menu Item About Me");
    } else if(value.equals("Undo")){
      menuView.setLabel("You choose: Tool Bar Undo");
    } else if(value.equals("Redo")){
      menuView.setLabel("You choose: Tool Bar Redo");
    } else if(value.equals("Copy")){
      menuView.setLabel("You choose: Tool Bar Copy");
    } else if(value.equals("Cut")){
      menuView.setLabel("You choose: Tool Bar Cut");
    } else if(value.equals("Paste")){
      menuView.setLabel("You choose: Tool Bar Paste");
    } else if(menuView.jCheckBoxMenuItem_toolbar.isSelected()){
      menuView.enbleToolbar();
    } else if(!menuView.jCheckBoxMenuItem_toolbar.isSelected()){
      menuView.disableToolbar();
    }
  }
}
