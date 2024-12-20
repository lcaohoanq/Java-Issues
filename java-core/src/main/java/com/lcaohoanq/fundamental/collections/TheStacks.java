package com.lcaohoanq.fundamental.collections;

import java.util.List;
import java.util.Stack;

//LIFO: Pack of Pringles

// |                 | 5 <- Top of stack
// |                 | 4 
// |                 | 3
// |                 | 2 
// |_________________| 1 <- Bottom of stack (first element)

public class TheStacks {

  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.push(1); // insert
    stack.push(2); // insert
    stack.push(3); // insert
    stack.push(4); // insert
    stack.push(5); // insert
    System.out.println("Using peek()");
    System.out.println("Top element of stack: " + stack.peek()); // Top element of stack = 5
    System.out.println("Size: " + stack.size()); // 5
    System.out.println("Using pop()");
    System.out.println("Remove this top element: " + stack.pop()); // Remove top element = 5
    System.out.println("Size" + stack.size()); // 4

    System.out.println(stack.empty()); // false

    // ! pop(): synchronized -> using at multithreading environment
    // * Stack extends Vector ~ ArrayList (Vector -> synchronized)

    List<Integer> stack1 = new Stack<>();
    stack1.add(1);
    // stack1.push(2); //error

  }
}
