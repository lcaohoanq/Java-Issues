package com.lcaohoanq.fundamental.oop.cutter;

//shape là class cha của mọi hình
//tam giác, vuông, tròn
//nếu nó là cha thì nó phải làm sao
//cha chỉ được chứa những điểm chung của các con 
//tại sao: nếu có điểm riêng thì sẽ truyền cho con -> không ổn

public abstract class Shape {
    //double edge; hình tròn có cạnh ????
    //double radius: tam giác, hvuong có radius ???
    protected String owner;
    protected String color;
    //tạo phễu

    public Shape(String owner, String color) {
        this.owner = owner;
        this.color = color;
    }

    public String getOwner() {
        return owner;
    }

    public String getColor() {
        return color;
    }
    //cha phải lưu các điểm chung -> tính diện tích, chu vi
    
    //cha không viết công thức để con tự định nghĩa
    public abstract double getPerimeter();
    public abstract double getArea();
    public abstract void paint();
    //câu hỏi pv:
    //1.tại sao lại không viết công thức cho diện tích và chu vi ở đây?
    //       không có công thức tính chung cho tất cả các hình
    //nếu mình bỏ 1 công thức nào đó vào đấy thì các thằng con
    //sẽ kế thừa công thức đó, và công thức đó không đúng với nó
    
    //2.tại sao class Shape lại là abstract class?
    //Vì: nó có chứa abstract method -> abstract class
    
    //3.tại sao lại có abstract method?
    //vì: không phải mày đã hỏi tao sao ku ????
    
    //**Lưu ý về abstract Class:
    //abstract Class được ví như một cái khuôn bị thủng
    //nếu thủng thì không đúc được
    //abstract class thì không tạo được object 
    //(nếu mà tạo được thì object sẽ có những method không có code -> không dùng được)
    
    //vậy abstract class cần làm gì? sẽ cần class khác kế thừa 
    //Tại sao cần class khác kế thừa ? 
    //Để vá lỗ hổng mà người đi trước để lại
    //vá lỗ thủng và Shape chưa định nghĩa (getPerimeter, getArea, paint)
    
    //vậy nếu class kế thừa đó không vá được hết?
    //Cần class khác kế thừa và vá tiếp những gì chưa xong
    
    //abstract class không tạo được object
    //nhưng mà ta có thể cố chấp dùng cái khuôn thủng để đúc object
    //kĩ thuật anonymous (ẩn danh)
    
    
}
