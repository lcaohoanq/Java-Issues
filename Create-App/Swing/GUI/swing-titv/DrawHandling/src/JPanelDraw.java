import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class JPanelDraw extends JPanel {

  public JPanelDraw() {
    this.setBackground(Color.YELLOW);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.RED);
    g.drawLine(15,15,50,150);

    g.setColor(Color.BLUE);
    g.drawOval(255, 255, 100, 100);

    g.setColor(Color.GREEN);
    g.drawRect(100, 100, 100, 100);

    g.setColor(Color.BLACK);
    g.drawString("Hello World!", 100, 100);

    g.setColor(Color.PINK);
    g.fillOval(400,300,50,50);
  }
}
