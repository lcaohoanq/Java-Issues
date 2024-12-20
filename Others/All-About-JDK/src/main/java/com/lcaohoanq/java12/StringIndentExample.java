package com.lcaohoanq.java12;

public class StringIndentExample {

    public static void main(String[] args) {

        String inputString = "Hello World From Java 12                ";

        String indentString = inputString.indent(2);

        System.out.println("Original String: " + inputString);
        System.out.println("Indented String: " + indentString);

    }

}
