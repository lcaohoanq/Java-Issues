package layerButton;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {

  private JPanel jPanel_container;
  private JButton jButton_1;
  private JButton jButton_2;
  private CardLayout cardLayout;

  public Main() {
    jPanel_container = new JPanel();
    cardLayout = new CardLayout();
    jPanel_container.setLayout(cardLayout);

    jButton_1 = new JButton("Button 1");
    jButton_2 = new JButton("Button 2");

    jButton_1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        cardLayout.next(jPanel_container); // Switch to the next card
      }
    });

    jPanel_container.add(jButton_1, "Card1");
    jPanel_container.add(jButton_2, "Card2");

    setTitle("Layered Button");
    setSize(300, 150);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.add(jPanel_container);
  }

  public static void main(String[] args) {
    try {
      java.awt.EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
          Main ex = new Main();
          ex.setVisible(true);
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
