package com.lcaohoanq.jdk.src.main.java.com.lcaohoanq.java12;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TeeingExample {

    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3);

        // teeing allow us to perform two Collectors operations in parallel and then merge the results
        double result = stream.collect(
            Collectors.teeing(
                Collectors.summingDouble(i -> i), //Collectors.summing(Integer::doubleValue)
                Collectors.counting(),
                (sum, count) -> sum / count
            )
        );

        System.out.println("Result: " + result);

    }

}
