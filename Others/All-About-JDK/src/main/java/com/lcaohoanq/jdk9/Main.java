package com.lcaohoanq.jdk9;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> list = List.of("A", "B", "C");
        list.stream().forEach(System.out::println);

        //https://www.tutorialspoint.com/differences-between-takewhile-and-dropwhile-methods-in-java-9
        /*
        The takewhile() method of Stream API accepts all values until predicate
        returns false whereas dropWhile() method of Stream API drops all values
        until it matches the predicate. If a stream is ordered, the takewhile() method
        returns a stream consisting of the longest prefix of elements taken from this stream
        that matches predicate whereas the dropWhile() method returns the
        remaining stream after matching predicate. If the stream is unordered, the takewhile()
        method returns a stream consisting of a subset of elements extracted from a stream
        that matches the given predicate whereas the dropWhile() method returns a stream
        consisting of the remaining elements of a stream after dropping a subset of elements
        that matches the given predicate.
        */

        // Ví dụ 1: takeWhile
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> lessThanFive = numbers.stream()
            .takeWhile(n -> n < 5)
            .collect(Collectors.toList());

        System.out.println("Số nhỏ hơn 5: " + lessThanFive);

        // Ví dụ 2: dropWhile
        List<Integer> greaterThanThree = numbers.stream()
            .dropWhile(n -> n <= 3)
            .collect(Collectors.toList());

        System.out.println("Số lớn hơn 3: " + greaterThanThree);

        // Ví dụ 3: ofNullable

        // Ví dụ 3: ofNullable
        String value1 = "Xin chào";
        String value2 = null;

        // Ví dụ với giá trị không rỗng
        Optional.ofNullable(value1)
            .ifPresentOrElse(v -> System.out.println("Ví dụ ofNullable - Giá trị không rỗng: " + v),
                () -> System.out.println("Ví dụ ofNullable - Giá trị rỗng"));

        // Ví dụ với giá trị rỗng
        Optional.ofNullable(value2)
            .ifPresentOrElse(v -> System.out.println("Ví dụ ofNullable - Giá trị không rỗng: " + v),
                () -> System.out.println("Ví dụ ofNullable - Giá trị rỗng"));

        // Ví dụ của luồng an toàn với giá trị null
        List<String> names = Arrays.asList("Alice", "Bob", null, "Charlie", null, "David");
        List<String> nonNullNames = names.stream()
            .flatMap(name -> Main.nullSafeStream(name))
            .collect(Collectors.toList());

        System.out.println("Các tên không rỗng: " + nonNullNames);

        processAPI();
    }

    // Phương thức hỗ trợ để tạo một luồng từ một giá trị có thể là null
    private static <T> java.util.stream.Stream<T> nullSafeStream(T value) {
        return value == null ? java.util.stream.Stream.empty() : java.util.stream.Stream.of(value);
    }

    static void processAPI() {
        ProcessHandle currentProcess = ProcessHandle.current();
        System.out.println("Current Process Id: " + currentProcess.pid());
        System.out.println("Current Process Info: " + currentProcess.info());
    }

}
