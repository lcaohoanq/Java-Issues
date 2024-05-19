package layout;

import javax.swing.*;
import java.awt.*;

public class GridHandling {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Custom GridLayout Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            JPanel mainPanel = new JPanel(new GridLayout(6, 1));

            // Hidden buttons panel
            JPanel hiddenPanel = new JPanel(new GridLayout(1, 3));
            hiddenPanel.add(new JButton("Button 1"));
            hiddenPanel.add(new JButton("Button 2"));
            hiddenPanel.add(new JButton("Button 3"));

            // Merged buttons panel
            JPanel mergedPanel = new JPanel(new GridLayout(1, 2));
            mergedPanel.add(new JButton("Merged Button 1"));
            mergedPanel.add(new JButton("Merged Button 2"));

            // Adding panels to the main panel
            mainPanel.add(hiddenPanel);
            mainPanel.add(new JButton("Button 4")); // Add any additional buttons as needed
            mainPanel.add(new JButton("Button 5"));
            mainPanel.add(new JButton("Button 6"));
            mainPanel.add(new JButton("Button 7"));
            mainPanel.add(mergedPanel);

            frame.add(mainPanel);
            frame.setVisible(true);
        });
    }
}
