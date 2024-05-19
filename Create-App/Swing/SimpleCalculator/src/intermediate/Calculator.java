package intermediate;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class Calculator extends JFrame {

    public Calculator() {
        initCalculator();
    }

    private void initCalculator() {
        
        add(new Gui());
        setTitle("Calculator");
        setSize(300, 300);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); //center
        setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); //mac os
            new Calculator();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
