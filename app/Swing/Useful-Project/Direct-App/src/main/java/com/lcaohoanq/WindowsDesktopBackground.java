package com.lcaohoanq;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.win32.W32APIOptions;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.imageio.ImageIO;

public class WindowsDesktopBackground {
    public interface User32 extends Library {
        User32 INSTANCE = (User32) Native.loadLibrary("user32", User32.class, W32APIOptions.DEFAULT_OPTIONS);

        boolean SystemParametersInfo(int uiAction, int uiParam, String pvParam, int fWinIni);
    }

//    public static void setDesktopBackground(String imagePath) {
//        User32.INSTANCE.SystemParametersInfo(0x0014, 0, imagePath, 1);
//    }

    public static void setDesktopBackground(String imagePath) {
        URL url = WindowsDesktopBackground.class.getResource(imagePath);
        if (url == null) {
            throw new IllegalArgumentException("The provided image path is not valid.");
        }
        String absolutePath = new File(url.getPath()).getAbsolutePath();
        User32.INSTANCE.SystemParametersInfo(0x0014, 0, absolutePath, 1);
    }


    public static void setDesktopBackgroundAsStream(String resourcePath) {
        try {
            // Get the image as a stream
            InputStream is = WindowsDesktopBackground.class.getResourceAsStream(resourcePath);
            if (is == null) {
                throw new IllegalArgumentException("Resource not found: " + resourcePath);
            }

            // Convert the stream to a BufferedImage
            BufferedImage img = ImageIO.read(is);

            // Create a temporary file
            Path tempFile = Files.createTempFile("background", ".jpg");

            // Write the image to the temporary file
            ImageIO.write(img, "jpg", tempFile.toFile());

            // Set the desktop background
            User32.INSTANCE.SystemParametersInfo(0x0014, 0, tempFile.toString(), 1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        setDesktopBackground("C:\\Users\\lcaohoanq\\Downloads\\image.jpg");
//        setDesktopBackground("/image.jpg");
        setDesktopBackgroundAsStream("/camera.jpg");

    }
}
