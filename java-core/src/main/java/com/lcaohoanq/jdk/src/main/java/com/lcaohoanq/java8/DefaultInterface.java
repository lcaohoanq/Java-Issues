package com.lcaohoanq.jdk.src.main.java.com.lcaohoanq.java8;

public interface DefaultInterface {

    default void myDefaultMethod() {
        System.out.println("My default method");
    }

    void honk();

}
