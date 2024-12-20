import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class MenuView extends JFrame {

  JPanel panel;
  JMenuBar menuBar;
  JMenu menuFile;
  JMenu menuHelp;

  JMenuItem menuNew;
  JMenuItem menuOpen;
  JMenuItem menuExit;
  JMenuItem menuAboutMe;
  JLabel label;
  JToolBar jToolBar;
  JButton jButton_undo;
  JButton jButton_redo;
  JButton jButton_copy;
  JButton jButton_cut;
  JButton jButton_paste;
  JPopupMenu jPopupMenu;
  ActionListener ac = new MenuController(this);
  Font font = new Font("Verdana", Font.BOLD, 20);

  public MenuView() {
    this.setTitle("Menu");
    this.setSize(400, 400);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    initMenu();
  }

  private void initMenu() {

    panel = new JPanel(new BorderLayout());
    menuBar = new JMenuBar();
//    menuBar.setLocation(0, 0);
    menuFile = new JMenu("File");
    menuFile.setMnemonic(KeyEvent.VK_F);
    menuHelp = new JMenu("Help");
    menuHelp.setMnemonic(KeyEvent.VK_L);

    menuNew = new JMenuItem("New", KeyEvent.VK_N);
    menuNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK)); // CTRL + N
    menuOpen = new JMenuItem("Open", KeyEvent.VK_O);
    menuOpen.setAccelerator(
        KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK)); // CTRL + O
    menuExit = new JMenuItem("Exit", KeyEvent.VK_X);
    menuExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK)); //CTRL + X
    menuFile.add(menuNew);
    menuFile.add(menuOpen);
    menuFile.add(menuExit);

    menuAboutMe = new JMenuItem("About Me");
    menuHelp.add(menuAboutMe);
    menuBar.add(menuFile);
    menuBar.add(menuHelp);

    label = new JLabel("You choose:");
    label.setFont(font);

    menuFile.addActionListener(ac);
    menuHelp.addActionListener(ac);
    menuNew.addActionListener(ac);
    menuOpen.addActionListener(ac);
    menuExit.addActionListener(ac);
    menuAboutMe.addActionListener(ac);

    this.setJMenuBar(menuBar);
//    panel.add(menuBar, BorderLayout.NORTH);
    panel.add(label, BorderLayout.CENTER);

    //! Tạo toolbar
    jToolBar = new JToolBar(); //chua cac button
    jToolBar.setFloatable(false); //khong cho di chuyen

    jButton_undo = new JButton("Undo");
    jButton_undo.setToolTipText("Ctrl + Z, de khoi phuc thao tac cu");
    jButton_redo = new JButton("Redo");
    jButton_redo.setToolTipText("Ctrl + Y, de thuc hien lai thao tac vua undo");
    jButton_copy = new JButton("Copy");
    jButton_copy.setToolTipText("Ctrl + C, de copy");
    jButton_cut = new JButton("Cut");
    jButton_cut.setToolTipText("Ctrl + X, de cut");
    jButton_paste = new JButton("Paste");
    jButton_paste.setToolTipText("Ctrl + V, de paste");
//    jButton_undo.setAceelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
    //! Khong tao truc tiep phim tat cho button duoc

    jToolBar.add(jButton_undo);
    jToolBar.add(jButton_redo);
    jToolBar.add(jButton_copy);
    jToolBar.add(jButton_cut);
    jToolBar.add(jButton_paste);

    jButton_undo.addActionListener(ac);
    jButton_redo.addActionListener(ac);
    jButton_copy.addActionListener(ac);
    jButton_cut.addActionListener(ac);
    jButton_paste.addActionListener(ac);

    //! Tạo popup menu
    jPopupMenu = new JPopupMenu();

    JMenu jMenuPopupFont = new JMenu("Font");
    JMenuItem jMenuItemType = new JMenuItem("Type");
    JMenuItem jMenuItemSize = new JMenuItem("Size");
    JMenuItem jMenuItemCut = new JMenuItem("Cut");
    JMenuItem jMenuItemCopy = new JMenuItem("Copy");
    JMenuItem jMenuItemPaste = new JMenuItem("Paste");
    jMenuPopupFont.add(jMenuItemType);
    jMenuPopupFont.add(jMenuItemSize);
    jPopupMenu.add(jMenuPopupFont);
    jPopupMenu.addSeparator(); //tao duong ke ngang
    jPopupMenu.add(jMenuItemCut);
    jPopupMenu.add(jMenuItemCopy);
jPopupMenu.add(jMenuItemPaste);
    //! JMenuIteam la 1 thang cuoi cung, neu trong menu co nhieu lop thi cu JMenu, JMenu thi se chong len nhau

    //! Lien ket voi su kien click chuot
//    panel.add(jPopupMenu);
    panel.setComponentPopupMenu(jPopupMenu);
    //! add vao panel

    MenuMouseController mmc = new MenuMouseController(this);
    this.addMouseListener(mmc);

    this.add(jToolBar, BorderLayout.NORTH);
    this.add(panel);
    this.setVisible(true);
  }

  public void clickNew() {
    label.setText("You choose: New");
  }

  public void clickOpen() {
    label.setText("You choose: Open");
  }

  public void clickExit() {
    System.exit(0);
  }

  public void clickAboutMe() {
    label.setText("You choose: AboutMe");
  }

  //! Tạo ham cach nay su dung cho gon, nang cao tinh module
  public void setLabel(String text) {
    label.setText(text);
  }

}
