package view;

import controller.AppController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;
import model.AppModel;
import sun.invoke.empty.Empty;

public class AppGui extends JPanel {

  public AppModel appModel;
  JLabel jLabel_count;
  Font font = new Font("Arial", Font.BOLD, 20);
  EmptyBorder emptyBorder = new EmptyBorder(10, 10, 10, 10);
  JPanel jPanel_position = new JPanel(new FlowLayout(FlowLayout.LEFT));
  JPanel jPanel_count = new JPanel(new FlowLayout(FlowLayout.LEFT));
  JPanel jPanel_inside = new JPanel(new FlowLayout(FlowLayout.LEFT));

  JPanel jPanel_bottom = new JPanel(new GridLayout(3,3));
  JPanel jPanel_empty1 = new JPanel();
  JPanel jPanel_empty2 = new JPanel();
  JLabel jLabel_x = new JLabel("X: ", JLabel.RIGHT);
  JLabel jLabel_y = new JLabel("Y: ", JLabel.RIGHT);
  JLabel jLabel_inside = new JLabel("false", JLabel.RIGHT);
  JLabel jLabel_count_title;
  JPanel jPanel_data;
  JTextArea textArea;
  JLabel jLabel_inside_title;

  JLabel jLabel_position_title;
  int count = 0;

  public AppGui() {
    this.appModel = new AppModel();
    initGui();
  }

  private void initGui() {
    textArea = new JTextArea(20, 50);
    textArea.setEditable(false);
    textArea.setBackground(new Color(76, 187, 23));

    jPanel_data = new JPanel();
    jPanel_data.setLayout(new BorderLayout());

    jLabel_position_title = new JLabel("Position");
    jLabel_position_title.setFont(font);
    jLabel_x = new JLabel("X: ", JLabel.RIGHT);
    jLabel_x.setFont(font);
    jLabel_x.setForeground(Color.RED);
    jLabel_y = new JLabel("Y: ", JLabel.RIGHT);
    jLabel_y.setFont(font);
    jLabel_y.setForeground(Color.RED);
    jLabel_count_title = new JLabel("Number of clicks: ");
    jLabel_count_title.setFont(font);
    jLabel_count = new JLabel("0", JLabel.RIGHT);
    jLabel_count.setFont(font);
    jLabel_count.setForeground(Color.BLACK);
    jLabel_inside_title = new JLabel("Mouse inside the frame: ");
    jLabel_inside_title.setFont(font);
    jLabel_inside = new JLabel("false", JLabel.RIGHT);
    jLabel_inside.setFont(font);
    jLabel_inside.setForeground(Color.RED);
    MouseListener ml = new AppController(this);
    textArea.addMouseListener(ml);

    jPanel_bottom.add(jLabel_position_title);
    jPanel_bottom.add(jLabel_x);
    jPanel_bottom.add(jLabel_y);
    jPanel_bottom.add(jLabel_count_title);
    jPanel_bottom.add(jLabel_count);
    jPanel_bottom.add(jPanel_empty1);
    jPanel_bottom.add(jLabel_inside_title);
    jPanel_bottom.add(jLabel_inside);
    jPanel_bottom.add(jPanel_empty2);

    jPanel_bottom.setBorder(emptyBorder);


    setLayout(new BorderLayout());
    add(textArea, BorderLayout.CENTER);
    add(jPanel_bottom, BorderLayout.SOUTH);
  }

  public void setXLocation(int x) {
//    jLabel_x.setText("X: " + String.valueOf(x));
    jLabel_x.setText("X: " + x);
  }

  public void setYLocation(int y) {
//    jLabel_y.setText(String.valueOf(y));
    jLabel_y.setText("Y: " + y);
  }

  public void countClick() {
    count++;
    appModel.setCount(count);
    jLabel_count.setText(String.valueOf(appModel.getCount()));
  }

  public void setInside(boolean isInside) {
    if (isInside) {
      jLabel_inside.setText("YES");
      jLabel_inside.setForeground(new Color(76, 187, 23));
    } else {
      jLabel_inside.setText("NO");
      jLabel_inside.setForeground(Color.RED);
    }
  }
}
