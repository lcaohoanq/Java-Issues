package com.lcaohoanq.jdk.src.main.java.com.lcaohoanq.java16;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPI {

    public static void main(String[] args) {
        //before java 16 using collectors.toList()
        Stream<String> stringStreamBeforeJava16 = Stream.of("A", "B", "C", "D");
        List<String> stringListBeforeJava16 = stringStreamBeforeJava16.collect(Collectors.toList());
        System.out.println("Before Java 16: " + stringListBeforeJava16);

        //after java 16 using Collectors.toList()
        Stream<String> stringStreamAfterJava16 = Stream.of("A", "B", "C", "D");
        List<String> stringListAfterJava16 = stringStreamAfterJava16.toList();
        System.out.println("After Java 16: " + stringListAfterJava16);

        //Stream.mapMulti()
        IntStream orginalStream = IntStream.of(1, 2, 3);

        orginalStream.mapMulti((int num, IntConsumer consumer) -> {
            for (int i = 1; i < num; i++) {
                consumer.accept(num * i);
            }
        }).forEach(System.out::println);


    }

}
