package com.lcaohoanq.java12;

import java.text.NumberFormat;
import java.text.NumberFormat.Style;
import java.util.Locale;

public class CompactNumberFormattingExample {

    public static void main(String[] args) {

        NumberFormat numberFormatJP = NumberFormat.getCompactNumberInstance(Locale.JAPAN, NumberFormat.Style.SHORT);

        System.out.println("Short format: " + numberFormatJP.format(1000)); //1,000
        System.out.println("Short format: " + numberFormatJP.format(100000)); //10万

        numberFormatJP = NumberFormat.getCompactNumberInstance(Locale.JAPAN, Style.LONG);

        System.out.println("Long format: " + numberFormatJP.format(23600000)); //2360万
        System.out.println("Long format: " + numberFormatJP.format(500000000)); // 5億

        NumberFormat numberFormatUS = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);

        System.out.println("Short format: " + numberFormatUS.format(1000)); //1K
        System.out.println("Short format: " + numberFormatUS.format(100000)); //100K

        numberFormatUS = NumberFormat.getCompactNumberInstance(Locale.US, Style.LONG);

        System.out.println("Long format: " + numberFormatUS.format(23600000)); //23.6 million
        System.out.println("Long format: " + numberFormatUS.format(500000000)); // 500 million


    }

}
