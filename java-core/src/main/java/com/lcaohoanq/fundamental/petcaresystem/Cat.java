package com.lcaohoanq.fundamental.petcaresystem;

public class Cat extends Pet {
    private String ribbon;

    public Cat(String id, String owner, String color, double weight, String ribbon) {
        super(id, owner, color, weight);
        this.ribbon = ribbon;
    }

    public String getRibbon() {
        return ribbon;
    }
    
    //setter
    public void setRibbon(String ribbon) {
        this.ribbon = ribbon;
    }
    
    @Override
    public void showInfor() {
        String str = String.format("%4s|%-15s|%-15s|%6.2f|%s",
                                id, owner, color, weight, ribbon);
        System.out.println(str);    
    }
    
    //toString

    @Override
    public String toString() {
        String str = String.format("%4s|%-15s|%-15s|%6.2f|%s",
                                id, owner, color, weight, ribbon);
        return str;
    }
    
    
}
