# Stream API Demo

This project demonstrates the key features of the Java Stream API using a simple example. The program showcases how to use the most commonly used stream operations such as `filter()`, `map()`, `reduce()`, `sorted()`, and more. It also includes examples of how to convert between different types of collections using the Stream API.

## Key Features

The `StreamAPIDemo.java` file demonstrates the following Stream API operations:

1. **Filter**: Select elements based on a condition.
    - Example: Filtering even numbers from a list.

2. **Map**: Transform each element in the stream.
    - Example: Squaring each number in a list.

3. **Reduce**: Perform aggregation operations.
    - Example: Summing all elements in a list.

4. **Sorted**: Sort elements in a stream.
    - Example: Sorting numbers in reverse order.

5. **Distinct**: Remove duplicates.
    - Example: Getting distinct numbers from a list.

6. **Count**: Count elements in a stream.
    - Example: Counting the number of even numbers.

7. **Limit**: Limit the number of elements.
    - Example: Getting the first 3 elements from a list.

8. **Skip**: Skip the first few elements.
    - Example: Skipping the first 5 numbers.

## Collection Conversion Features

In addition to the key operations, this demo highlights how to convert one collection type to another using the Stream API:

1. **List to Set**: Convert a `List` to a `Set` to remove duplicates.
    - Example: Using `Collectors.toSet()` to convert a list of integers to a `Set`.

2. **List to LinkedList**: Convert a `List` to a `LinkedList`.
    - Example: Using `Collectors.toCollection(LinkedList::new)` to convert a `List` of integers to a `LinkedList`.

3. **List to TreeSet**: Convert a `List` to a `TreeSet` (sorted and unique elements).
    - Example: Using `Collectors.toCollection(TreeSet::new)` to create a `TreeSet`.

4. **List to Map**: Convert a `List` to a `Map`, where each element can be a key, and the transformed element is the value.
    - Example: Using `Collectors.toMap()` to map integers to their squares.

5. **List to Uppercase List**: Convert a `List` of strings to another `List`, transforming each string to uppercase.
    - Example: Using `map()` to convert a list of names to uppercase.

6. **List to Unique Set**: Convert a `List` of strings to a `Set`, removing any duplicate strings.
    - Example: Using `Collectors.toSet()` to remove duplicate names from a list.

7. **Partitioning by Condition**: Partition a list of elements into two groups based on a predicate.
    - Example: Using `Collectors.partitioningBy()` to group numbers by whether they are odd or even.

8. **Joining Strings**: Convert a `List` of strings to a single comma-separated string.
    - Example: Using `Collectors.joining()` to join a list of names into a single string.

## Prerequisites

- Java 8 or later

## Running the Program

1. Clone this repository.
2. Compile and run the `StreamAPIDemo.java` file:
    ```bash
    javac StreamAPIDemo.java
    java StreamAPIDemo
    ```

## Example Output

```console
Converted to Set: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Converted to LinkedList: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Converted to TreeSet: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Converted to Map (Number -> Square): {1=1, 2=4, 3=9, 4=16, 5=25, 6=36, 7=49, 8=64, 9=81, 10=100}
Names in Uppercase: [ALICE, BOB, CHARLIE, DAVID, ALICE]
Unique Names: [Alice, Bob, Charlie, David]
Grouped by Odd and Even: {false=[1, 3, 5, 7, 9], true=[2, 4, 6, 8, 10]}
Names to Length Map: {Alice=5, Bob=3, Charlie=7, David=5}
Joined Names: Alice, Bob, Charlie, David
```
