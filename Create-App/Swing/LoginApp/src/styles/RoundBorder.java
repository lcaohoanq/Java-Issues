package styles;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import javax.swing.border.AbstractBorder;

public class RoundBorder extends AbstractBorder {
    private Color borderColor;
    private int cornerRadius;

    public RoundBorder(Color borderColor, int cornerRadius) {
        this.borderColor = borderColor;
        this.cornerRadius = cornerRadius;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        super.paintBorder(c, g, x, y, width, height);

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setColor(borderColor);
        g2d.drawRoundRect(x, y, width - 1, height - 1, cornerRadius, cornerRadius);

        g2d.dispose();
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(cornerRadius + 1, cornerRadius + 1, cornerRadius + 2, cornerRadius);
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        insets.left = insets.top = insets.right = insets.bottom = cornerRadius + 1;
        return insets;
    }
}
