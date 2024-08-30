package com.lcaohoanq.java9;

public interface MyInterface {

    void publicMethod();

    default void defaultMethod() {
        System.out.println("This is a default method");
        privateMethod();
    }

    private void privateMethod() {
        System.out.println("This is a private method");
    }

}
