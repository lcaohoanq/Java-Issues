package com.lcaohoanq.jdk.src.main.java.com.lcaohoanq.java16;

public class PatternMatchingInstanceOf {

    public static void main(String[] args) {
        Object obj = "Hello World";

        //before Java 16
        if (obj instanceof String) {
            String s = (String) obj;
            System.out.println(s.toUpperCase());
        } else {
            System.out.println("Not a string");
        }

        //Java 16
        if (obj instanceof String s) {
            System.out.println(s.toUpperCase());
        } else {
            System.out.println("Not a string");
        }
    }

}
