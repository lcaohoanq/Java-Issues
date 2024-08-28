import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class CreateBlankImage {
    public static void main(String[] args) {
        // Define image dimensions
        int width = 300;
        int height = 650;

        // Define color (in RGB format)
        Color color = new Color(25, 183, 25); // RGB value for #FF731D

        // Create a new buffered image with the specified dimensions and color
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                image.setRGB(x, y, color.getRGB());
            }
        }

        // Save the image as a JPG file
        try {
            File output = new File("/media/DATA/PERSONAL/Java/javafx/formhandling/src/main/resources/com/lcaohoanq/formhandling/assets/img/branding.png");
            ImageIO.write(image, "png", output);
            System.out.println("Blank image created successfully.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
