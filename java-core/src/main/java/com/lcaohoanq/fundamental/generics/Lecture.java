package com.lcaohoanq.fundamental.generics;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class Lecture<T> {

    private T id;
    private String name;
    
}
