import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class MainView extends JPanel implements ActionListener{
  JTextArea jTextArea_p;
  JTextArea jTextArea_s;
  JButton jButton;
  JLabel jLabel_title3;
  int count;
  public MainView() {
    initApp();
  }
  private void initApp() {
    JLabel jLabel_title1 = new JLabel("Văn bản", JLabel.LEFT);
     jTextArea_p = new JTextArea(7, 15);
     jTextArea_p.setLineWrap(true);
    JScrollPane jScrollPane = new JScrollPane(jTextArea_p, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    JLabel jLabel_title2 = new JLabel("Từ khoá", JLabel.LEFT);
     jTextArea_s = new JTextArea(1, 15);
      jTextArea_s.setLineWrap(true);
      jTextArea_s.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
     jButton = new JButton("Thống kê");
     jLabel_title3 = new JLabel("Kết quả: 0");

    Dimension pSize = new Dimension(305,111);
//    jTextArea_p.setPreferredSize(pSize);
    //! affect scrolling behavior when the text area is resized

    Dimension sSize = new Dimension(305,20);
    jTextArea_s.setPreferredSize(sSize);

    EmptyBorder border = new EmptyBorder(10,10,10,10);

    JPanel jPanel_top = new JPanel(new BorderLayout());
    jPanel_top.add(jLabel_title1, BorderLayout.NORTH);
//    jPanel_top.add(jTextArea_p, BorderLayout.CENTER);
    jPanel_top.add(jScrollPane, BorderLayout.CENTER);

    JPanel jPanel_middle = new JPanel(new BorderLayout());
    jPanel_middle.add(jLabel_title2, BorderLayout.NORTH);
    jPanel_middle.add(jTextArea_s, BorderLayout.CENTER);

    jButton.addActionListener(this);

    jButton.setBackground(Color.BLACK);
    jButton.setForeground(Color.WHITE);
    JPanel jPanel_bottom = new JPanel(new GridLayout(1,2,5,5)); //fflowlayout
    jPanel_bottom.add(jButton);
    jPanel_bottom.add(jLabel_title3);

    jLabel_title1.setBorder(border);
    jTextArea_p.setBorder(border);
    jLabel_title2.setBorder(border);
    jTextArea_s.setBorder(border);
    jPanel_bottom.setBorder(border);

    setLayout(new BorderLayout());
    setBorder(new EmptyBorder(10,10,10,10));
//    setBackground(Color.GRAY);
    add(jPanel_top, BorderLayout.NORTH);
    add(jPanel_middle, BorderLayout.CENTER);
    add(jPanel_bottom, BorderLayout.SOUTH); //SOUTH


  }
  @Override
  public void actionPerformed(ActionEvent e) {
    String userData = jTextArea_p.getText();
    countWord(userData);
  }

  private void countWord(String inputData){
    count = 0;
    String searchKey = jTextArea_s.getText();
    String[] words = inputData.split(" ");
    for (String word : words) {
      if(word.contains(",") || word.contains(".") || word.contains(";") || word.contains(":") || word.contains("?") || word.contains("!")){
        word = word.substring(0, word.length()-1);
        if(word.equals(searchKey)){
          count++;
        }
      }else{
        if(word.equals(searchKey)){
          count++;
        }
      }
    }
    jLabel_title3.setText("Kết quả: có " + count + " từ "+ searchKey);
  }

}
