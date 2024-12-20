package com.lcaohoanq.fundamental.collections;

import java.util.ArrayList;
import java.util.List;

public class TheLists {

  public static void main(String[] args) {

    // ! If not define the List data type, it can be hold anything
//    List colors = new ArrayList();
//    colors.add("blue");
//    colors.add("purple");
//    colors.add(1);
//    colors.add(new Object());

    // * Instead

    List<String> colors = new ArrayList<>();
    colors.add("blue");
    colors.add("purple");
    colors.add("yellow");
    System.out.println(colors.size()); //3
    System.out.println(colors.contains("red")); //false
    System.out.println(colors.contains("blue")); //false
    System.out.println(colors); //[blue, purple, yellow]

    // * Traversal
    for (int i = 0 ; i <= colors.size() - 1; i++){
      System.out.println(colors.get(i));
    }

    for (String item: colors){
      System.out.println(item);
    }

    // ! Do not use stream, directly pass the action
    colors.forEach(System.out::println);

    //TODO immutable List -> JDK9 above
//    List<String> colorsUnmodifiable = List.of(
//        "blue",
//        "yellow",
//    );



  }
}
