package com.lcaohoanq._generics;

import com.lcaohoanq._abstract.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student <T> extends Person {

    private T id;
    private String name;
    private int yob;
    private int gpa;

    private static  <T> void  print(T value){
        System.out.println("Type of " + value + " is " + value.getClass().getName());
    }

    public static void main(String[] args) {
        Student<Integer> student1 = new Student<>(1, "John", 2000, 3);
        Student<String> student2 = new Student<>("2", "Jane", 2001, 4);
        System.out.println(student1);
        System.out.println(student2);

        //method generics
        print(student1);
        print("Hello world!");
    }

    @ToString
    @AllArgsConstructor
    static class Student2<T extends Number>{

        private T id;
        private String name;
        private int yob;

        public static void main(String[] args) {
            Student2<Number> student1 = new Student2<>(23, "John", 2000);
            System.out.println(student1);
        }

    }

    @ToString
    @AllArgsConstructor
    static class Student3<T, U, K>{

        private T id;
        private U name;
        private K yob;

        public static void main(String[] args) {
            Student3<Number, String, Integer> student1 = new Student3<>(23, "John", 2000);
            System.out.println(student1);
        }

    }

    @ToString
    @AllArgsConstructor
    static class Student4<T extends Integer, U extends String>{

        private T id;
        private U name;
        private int yob;

        public static void main(String[] args) {
            Student4<Integer, String> student1 = new Student4<>(23, "John", 2000);
            System.out.println(student1);
        }

    }

    @ToString
    @AllArgsConstructor
    static class Student5<T ,  U>{

        private T id;
        private String name;
        private int yob;
        private U lecture;

        public static void main(String[] args) {
            Lecture<String> lecture = new Lecture<>("lcaohoanq", "Java");
            Student5<Integer,  Lecture<String>> student1 = new Student5<>(23, "John", 2000, lecture);
            System.out.println(student1);
        }

    }

}
