package imageHandling;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageFromURL {
    public static void main(String[] args) throws IOException{
        JFrame frame = new JFrame("Loading Image from URL");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(400, 400));
        
        //load image
        JLabel image = loadImage("https://images.unsplash.com/photo-1685716851721-7e1419f2db18?q=80&w=1032&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
        
        frame.getContentPane().add(image);
        frame.setVisible(true);
    }
    
    public static JLabel loadImage(String source) throws IOException{
        URL url = new URL(source);
        BufferedImage image = ImageIO.read(url);
        return new JLabel(new ImageIcon(image));
    }
}
