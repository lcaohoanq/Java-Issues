/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package runtime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author Admin
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TimeZone tz = TimeZone.getTimeZone("Asia/Ho_Chi_Minh");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'"); // Quoted "Z" to indicate UTC, no timezone offset
        df.setTimeZone(tz);
        String nowAsISO = df.format(new Date());
        
        System.out.println(nowAsISO);
        
    }
    
    public static void twoTypeHour(){
        DateFormat df24 = new SimpleDateFormat("HH:mm:ss"); // 24-hour format
        DateFormat df12 = new SimpleDateFormat("hh:mm:ss a"); // 12-hour format, a Represents the AM/PM marker.

        Date currentTime = new Date();

        String time24 = df24.format(currentTime);
        String time12 = df12.format(currentTime);

        System.out.println("24-hour format: " + time24);
        System.out.println("12-hour format: " + time12);
    }

}
