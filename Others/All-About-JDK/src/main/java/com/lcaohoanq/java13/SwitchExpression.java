package com.lcaohoanq.java13;

public class SwitchExpression {

    public static void main(String[] args) {
        var me = 4;
        var operation = "squareMe";
        var result = switch (operation) {
            case "doubleMe" -> me * 2;
            case "squareMe" -> me * me;
            default -> me;
        };

        System.out.println("Result: " + result);

    }

}
