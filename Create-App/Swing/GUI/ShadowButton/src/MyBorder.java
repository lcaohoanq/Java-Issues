import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.Border;

/**
 *
 */
public class MyBorder implements Border {

    private int thickness_ = 4;
    private Color white = Color.WHITE;
    private Color gray = Color.GRAY;
    private Color black = Color.BLACK;

    public static void main(String[] args) {

        JFrame frm = new JFrame("Border Test");
        frm.setLayout(new FlowLayout());
        frm.setLocationRelativeTo(null);
        JButton btn = new JButton("Button");

        MyBorder border = new MyBorder();

        btn.setBorder(border);
        btn.setFocusPainted(false);
        btn.setPreferredSize(new Dimension(60,30));
        btn.setBackground(Color.LIGHT_GRAY);

        frm.add(btn);
        frm.setSize(200,200);
        frm.setVisible(true);

    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width,
                            int height) {
        Color oldColor = g.getColor();
        int i;

        for (i = 0; i < thickness_; i++) {
            g.setColor(white);
            g.drawRect(x + i, y + i, width - i - i - 1, height - i - i - 1); //White Rectangle
        }
        for (i = 0; i < thickness_/2; i++) {
            g.setColor(black);
            g.drawLine(x + i, y + i, (width - x) - (i * 2), y + i); //Top Outer Edge
            g.drawLine(x + i, y + i, x + i, (height - y) - (i * 2));  //Left Outer Edge
        }
        for (i = thickness_/2; i < thickness_; i++) {
            g.setColor(gray);
            g.drawLine(x + i, y + i, (width - x) - (i * 2), y + i); //Top Inner Edge
            g.drawLine(x + i, y + i, x + i, (height - y) - (i * 2)); //Left Inner Edge

        }
        g.setColor(oldColor);
    }

    public int getThickness() {
        return thickness_;
    }

    public void setThickness(int i) {
        thickness_ = i;
    }

    public boolean isBorderOpaque() {
        return true;
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(thickness_, thickness_, thickness_, thickness_);
    }

}