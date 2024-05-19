/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package runtime;

import java.awt.FileDialog;
import java.awt.Frame;
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FileDialog fileDialog = new FileDialog(new Frame(), "Select File");
        fileDialog.setVisible(true);

        String directory = fileDialog.getDirectory();
        String filename = fileDialog.getFile();

        if (directory != null && filename != null) {
            String path = directory + filename;
            System.out.println("Selected path: " + path);
        }
    }
    
}

