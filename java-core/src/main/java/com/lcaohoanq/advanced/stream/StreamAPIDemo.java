package com.lcaohoanq.advanced.stream;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;


public class StreamAPIDemo {

    public static void main(String[] args) {
        // Sample data
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Filter: Get even numbers
        List<Integer> evenNumbers = numbers.stream()
            .filter(n -> n % 2 == 0)
            .toList();
        System.out.println("Even Numbers: " + evenNumbers);

        // Map: Square each number
        List<Integer> squaredNumbers = numbers.stream()
            .map(n -> n * n)
            .toList();
        System.out.println("Squared Numbers: " + squaredNumbers);

        // Reduce: Sum of all numbers
        Optional<Integer> sum = numbers.stream()
            .reduce((a, b) -> a + b);
        sum.ifPresent(s -> System.out.println("Sum: " + s));

        // Sorted: Sort the numbers in reverse order
        List<Integer> reverseSortedNumbers = numbers.stream()
            .sorted((a, b) -> b - a)
            .toList();
        System.out.println("Reverse Sorted Numbers: " + reverseSortedNumbers);

        // Distinct: Remove duplicates
        List<Integer> distinctNumbers = Arrays.asList(1, 2, 2, 3, 3, 4, 4).stream()
            .distinct()
            .toList();
        System.out.println("Distinct Numbers: " + distinctNumbers);

        // Count: Count even numbers
        long count = numbers.stream()
            .filter(n -> n % 2 == 0)
            .count();
        System.out.println("Count of Even Numbers: " + count);

        // Limit: Get first 3 numbers
        List<Integer> firstThreeNumbers = numbers.stream()
            .limit(3)
            .toList();
        System.out.println("First Three Numbers: " + firstThreeNumbers);

        // Skip: Skip the first 5 numbers
        List<Integer> skipFirstFive = numbers.stream()
            .skip(5)
            .toList();
        System.out.println("After Skipping First Five: " + skipFirstFive);
    }
}

class StreamCollectionConversionDemo {

    public static void main(String[] args) {
        // Initial list of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 1. Convert List to Set (remove duplicates and maintain unique values)
        Set<Integer> numberSet = numbers.stream()
            .collect(Collectors.toSet());
        System.out.println("Converted to Set: " + numberSet);

        // 2. Convert List to LinkedList
        LinkedList<Integer> linkedList = numbers.stream()
            .collect(Collectors.toCollection(LinkedList::new));
        System.out.println("Converted to LinkedList: " + linkedList);

        // 3. Convert List to TreeSet (sorted and unique values)
        TreeSet<Integer> sortedSet = numbers.stream()
            .collect(Collectors.toCollection(TreeSet::new));
        System.out.println("Converted to TreeSet: " + sortedSet);

        // 4. Convert List to Map (Key = Number, Value = Square of the Number)
        Map<Integer, Integer> numberSquareMap = numbers.stream()
            .collect(Collectors.toMap(n -> n, n -> n * n));
        System.out.println("Converted to Map (Number -> Square): " + numberSquareMap);

        // 5. Convert List of Strings to Uppercase List
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Alice");
        List<String> uppercaseNames = names.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());
        System.out.println("Names in Uppercase: " + uppercaseNames);

        // 6. Convert List of Strings to Set (removing duplicates)
        Set<String> uniqueNames = names.stream()
            .collect(Collectors.toSet());
        System.out.println("Unique Names: " + uniqueNames);

        // 7. Grouping: Group List of Numbers by Odd and Even
        Map<Boolean, List<Integer>> oddEvenGrouping = numbers.stream()
            .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Grouped by Odd and Even: " + oddEvenGrouping);

        // 8. Convert List to Map (with length of each name as value)
        Map<String, Integer> nameLengthMap = names.stream()
            .collect(Collectors.toMap(name -> name, String::length, (existing, replacement) -> existing));
        System.out.println("Names to Length Map: " + nameLengthMap);

        // 9. Joining: Convert List of Strings to a Single String
        String joinedNames = names.stream()
            .distinct()  // Optional: removing duplicates before joining
            .collect(Collectors.joining(", "));
        System.out.println("Joined Names: " + joinedNames);
    }
}

