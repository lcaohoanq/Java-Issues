package runtime;

import javax.swing.JFrame;

public class GUI extends JFrame {
    
    public GUI() {
        add(new App());
        
        setSize(100, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new GUI();
    }
    
}
