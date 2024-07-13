import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GlowButtonExample extends JFrame {

    private JButton glowButton;
    private Timer glowTimer;
    private float glowValue = 0.0f;

    public GlowButtonExample() {
        setTitle("Glow Button Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        glowButton = new JButton("Glow Button");
        glowButton.setFocusPainted(false); // Remove the default focus border

        // Add action listener to the button
        glowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(GlowButtonExample.this, "Button Clicked!");
            }
        });

        // Set up timer for animation
        glowTimer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update the glow value
                glowValue = (float) (Math.sin(System.currentTimeMillis() * 0.005) + 1.0) / 2.0f;

                // Repaint the button
                glowButton.repaint();
            }
        });

        // Start the timer
        glowTimer.start();

        // Add the button to the frame
        add(glowButton);

        // Set up custom button painting
        glowButton.setOpaque(false);
        glowButton.setContentAreaFilled(false);
        glowButton.setBorderPainted(false);

        // Override the paintComponent method of the button
        glowButton = new JButton("Glow Button") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();

                // Draw the glow effect
                int glowRadius = (int) (glowValue * 20);
                int glowAlpha = (int) (glowValue * 200);
                g2d.setColor(new Color(0, 128, 255, glowAlpha));
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.fillRoundRect(-glowRadius, -glowRadius, getWidth() + glowRadius * 2, getHeight() + glowRadius * 2, 10, 10);

                // Call the original paintComponent method to draw the button text and other components
                super.paintComponent(g2d);

                g2d.dispose();
            }
        };
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GlowButtonExample().setVisible(true);
            }
        });
    }
}
