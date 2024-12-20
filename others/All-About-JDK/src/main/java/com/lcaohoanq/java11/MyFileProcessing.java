package com.lcaohoanq.java11;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class MyFileProcessing {

    static class ReadFileExample{
        public static void main(String[] args) throws IOException {
            Path path = Path.of("src/main/resources/test.txt");
            String content = Files.readString(path);
            System.out.println(content);
        }
    }

    static class WriteFileExample{
        public static void main(String[] args) throws IOException {
            Path path = Path.of("src/main/resources/test.txt");
            String content = "Hello Java 11";
            Files.writeString(path, content, StandardOpenOption.CREATE);
        }
    }

    static class ReadLineExample{
        public static void main(String[] args) throws IOException {
            Path path = Path.of("src/main/resources/test.txt");
            Files.readAllLines(path).forEach(System.out::println);
        }
    }

    static class WriteLineExample{
        public static void main(String[] args) throws IOException {
            Path path = Path.of("src/main/resources/test.txt");
            List<String> lines = List.of("Welcome", "to", "hell");
            Files.write(path, lines, StandardOpenOption.APPEND);
        }
    }

    static class BufferReaderExample{
        public static void main(String[] args) throws IOException {
            Path path = Path.of("src/main/resources/test.txt");
            Files.newBufferedReader(path).lines().forEach(System.out::println);
        }
    }

    static class BufferWriterExample {
        public static void main(String[] args) throws IOException {
            Path path = Path.of("src/main/resources/test.txt");
            try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {
                writer.write("\nHahahahahahahhahahah");
            }
        }
    }

    static class FileMismatchExample {
        public static void main(String[] args) throws IOException {
            Path path1 = Path.of("src/main/resources/test.txt");
            Path path2 = Path.of("src/main/resources/test2.txt");
            //different content: return 1
            //same content: return -1
            System.out.println(Files.mismatch(path1, path2));

            System.out.println("Different at: " + Files.mismatch(path1, path2));
        }
    }

}
