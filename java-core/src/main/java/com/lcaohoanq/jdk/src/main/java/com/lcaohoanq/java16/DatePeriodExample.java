package com.lcaohoanq.jdk.src.main.java.com.lcaohoanq.java16;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//Better choice than SimpleDateFormat, which is not thread-safe

public class DatePeriodExample {

    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();

        //Use "B" to display the
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd h:mm a");
        System.out.println("Current Date: " + now.format(formatter1)); //Current Date: 2024-09-03 8:37 PM

        //Use "B" to display the
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd h:mm a B");
        System.out.println("Current Date: " + now.format(formatter2)); //Current Date: 2024-09-03 8:37 PM in the evening

        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd h:mm a BBBB");
        System.out.println("Current Date: " + now.format(formatter3)); //Current Date: 2024-09-03 8:37 PM in the evening

    }

}
