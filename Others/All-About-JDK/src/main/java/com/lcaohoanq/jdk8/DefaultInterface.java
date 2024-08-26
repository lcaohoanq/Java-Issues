package com.lcaohoanq.jdk8;

public interface DefaultInterface {

    default void myDefaultMethod() {
        System.out.println("My default method");
    }

    void honk();

}
