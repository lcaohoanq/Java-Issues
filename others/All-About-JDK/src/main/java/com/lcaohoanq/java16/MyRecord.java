package com.lcaohoanq.java16;

/*
Record is immutable data carrier class introduced in Java 16. It is a final class and cannot
     be
 extended. It is a concise way to create classes without having to write boilerplate code.
*/
public record MyRecord(String name, int age) {

    public MyRecord() {
        this("", 0);
    }

    public MyRecord {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }

    public static void main(String[] args) {
        MyRecord myRecord = new MyRecord("Baeldung", 10);
        System.out.println("Name: " + myRecord.name());
        System.out.println("Age: " + myRecord.age());

        MyRecord myRecord1 = new MyRecord();
        System.out.println("Name: " + myRecord1.name());
        System.out.println("Age: " + myRecord1.age());
    }
}
