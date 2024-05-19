import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class CreateBlankImage {
    public static void main(String[] args) {
        // Define image dimensions
        int width = 228;
        int height = 407;

        // Define color (in RGB format)
        Color color = new Color(255, 115, 29); // RGB value for #FF731D

        // Create a new buffered image with the specified dimensions and color
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                image.setRGB(x, y, color.getRGB());
            }
        }

        // Save the image as a JPG file
        try {
            File output = new File("resources\\blank_image.jpg");
            ImageIO.write(image, "jpg", output);
            System.out.println("Blank image created successfully.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
