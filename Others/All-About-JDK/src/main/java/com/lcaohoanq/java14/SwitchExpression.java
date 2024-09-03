package com.lcaohoanq.java14;

public class SwitchExpression {

    public static void main(String[] args) {
        var me = 4;
        var operation = "doubleMe";
        var result = switch (operation) {
            case "doubleMe" -> {
                 me = me * 2;
                yield "This is a yield statement %d".formatted(me);
            }
            case "squareMe" -> me * me;
            default -> me;
        };

        System.out.println("Result: " + result instanceof String ? result : "This is a yield statement " + result);

    }

}
