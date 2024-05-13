package com.lcaohoanq.views;

import com.lcaohoanq.utils.ImageHandler;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class DataFrame extends JFrame {

    private JTextArea fileInfoArea;
    private JScrollPane dataPanel;
    private Border border = BorderFactory.createEmptyBorder(10, 10, 10, 10);

    public DataFrame(File file){
        this.setTitle("File Data Viewer");
        this.setSize(1000, 600);
        this.setIconImage(new ImageHandler().icon);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(false);

        initUI();
        appendFileData(file);
    }

    private void initUI(){
        fileInfoArea = new JTextArea();
        fileInfoArea.setFont(new Font("Roboto", Font.PLAIN, 15));
        fileInfoArea.setBorder(border);
        fileInfoArea.setEditable(false);

        dataPanel = new JScrollPane(fileInfoArea);
        dataPanel.addMouseWheelListener(e -> {
            if (e.isControlDown()) {
                Font currentFont = fileInfoArea.getFont();
                int newFontSize = currentFont.getSize() - e.getWheelRotation();
                if (newFontSize > 0) {
                    Font newFont = currentFont.deriveFont((float) newFontSize);
                    fileInfoArea.setFont(newFont);
                }
            }
        });

        this.add(dataPanel);
    }

    private void appendFileData(File file){
        // Read the data from the selected file
        try (BufferedReader reader = Files.newBufferedReader(file.toPath())) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileInfoArea.append(line + "\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
