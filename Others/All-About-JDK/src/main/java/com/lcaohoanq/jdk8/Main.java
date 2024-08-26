package com.lcaohoanq.jdk8;

import java.util.Arrays;
import java.util.List;

public class Main implements DefaultInterface {

    public static void main(String[] args) {
        //lambda expression
        //Before java 8
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("My Runnable");
            }
        };

        //After java 8
        Runnable r1 = () -> {
            System.out.println("My Runnable");
        };

        r.run();
        r1.run();

        //create own functional interface (FI)
        // FI have only one abstract method
        MyFunctionalInterface myFunctionalInterface = () -> {
            System.out.println("My Functional Interface");
        };

        myFunctionalInterface.myMethod();

        //stream api
        //stream vs parallel stream
        //https://www.baeldung.com/java-when-to-use-parallel-stream
        List<String> words = Arrays.asList("hello", "world", "java", "is", "cool", "cool");
        //words.add("not cool");

        //Array.asList is immutable, cannot change size of the list

        words.stream().forEach(System.out::println);
        words.stream().filter(item -> item.length() > 3).forEach(System.out::println);
        words.stream().findAny().ifPresent(
                s -> System.out.println(s + "123")
        );
        words.stream().findFirst().ifPresent(
                s -> System.out.println(s + "123")
        );
        words.stream().distinct().forEach(System.out::println); //removed the duplicate

        //System.out::println: method referenceces

        //Optional<>
        //isPresent(), isEmpty()

        //default method in interface
        //the default method do not need to implement in the class that implements the interface
        //default method can be override in the class that implements the interface

        Main main = new Main();
        main.honk();
        main.myDefaultMethod();
    }

    @Override
    public void honk() {
        System.out.println("Honk honk");
    }

}
