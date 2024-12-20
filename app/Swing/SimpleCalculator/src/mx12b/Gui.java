package mx12b;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class Gui extends JFrame{
    
    public Gui(){
        initGui();
    }
    
    private void initGui(){
        add(new App());
        
        setTitle("MX-12B");
//        setSize(new Dimension(378,232)); //cách tạo này nếu như cần một Dimension làm gì đó
//        setSize(400,600);
        pack();
        this.getContentPane().setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main(String[] args) {
//        try{
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); //mac os
//            new Gui();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
        new Gui();
    }
    
}
