package com.lcaohoanq.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.swing.JTextArea;

public class FileHandler {
    public static String getFileExtension(File file) {
        String fileName = file.getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }

//    public static void readFile(File file) {
//        // Read the data from the selected file
//        try (BufferedReader reader = Files.newBufferedReader(file.toPath())) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                fileInfoArea.append(line + "\n");
//            }
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }

//    public static void writeFile(String destination){
//        try{
//            File file = new File(destination);
//            if(file.createNewFile()){
//                System.out.println("File created: " + file.getName());
//            } else {
//                System.out.println("File already exists.");
//            }
//        } catch (Exception e){
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//    }

    public static void readFileAndAppendTo(JTextArea fileInfoArea, String url){
        try (BufferedReader reader = Files.newBufferedReader(new File(url).toPath())) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileInfoArea.append(line + "\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
