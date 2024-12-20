package com.lcaohoanq.java10;

import java.io.BufferedReader;
import java.net.http.HttpClient;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        //1. Local-Variable Type Inference (var)
        var b = "b";
        var c = 5; // int
        var d = 5.0; // double
        var httpClient = HttpClient.newHttpClient();

        var list = List.of(1, 2.0, "3");

        //var reader = new BufferedReader(null);
        // so với
        //BufferedReader reader2 = new BufferedReader(null);

        //2. Optional API - orElseThrow()
        try {

            Optional<String> optional = Stream.of("1Java", "2Kotlin", "Scala")
                .filter(s -> Character
                    .isDigit(s.charAt(0))).findAny();

            System.out.println("Result: " + optional.orElseThrow());

            String result = Stream.of("Java", "Kotlin", "Scala")
                .filter(s -> Character
                    .isDigit(s.charAt(0))).findAny()
                .orElseThrow();

            System.out.println("Result2: " + result);
        } catch (Exception e) {
            if (e instanceof NoSuchElementException) {
                System.out.println("No Such Element Error: " + e.getMessage());
            } else {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }


}
