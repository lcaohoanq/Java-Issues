package com.lcaohoanq.fundamental.oop.cutter;

public class Square extends Rectangle {
    
//không liệt kê được cái riêng
    public Square(String owner, String color, double edge) {
        super(owner, color, edge, edge);
    }
    //super = new Cha = new Rectangle
    
    //ông cha tui làm mẹ nó rồi -> diện tích, chu vi,
    //nhưng còn cấn cái hàm paint -> Độ lại
    
    
    @Override
    public void paint() {
        String str = String.format("Square        |%-10s|%-10s|%5.2f|%5.2f|%5.2f|%5.2f|", 
                                            owner,color,width,height, getPerimeter(),getArea());
        System.out.println(str);
    }
    public void draw(){
        System.out.println("I love you very much");
    }
}
