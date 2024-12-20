
package com.lcaohoanq.fundamental.oop.cutter;
//0. tạo class con
//1. khai báo đặc tính riêng của con
//2. cho con nhận cha bằng extends
//3. tạo phễu: constructor
//4. làm phần việc mà cha giao cho em (NẾU CÓ!!!)
//      là bổ sung code cho những abs method đã kế thừa
//      nếu mà thằng con không bổ sung thì nó sẽ trở thành abstract class và con của nó sẽ làm
//      nếu không có abstract method -> xem cái nào cần độ thì độ
public class Rectangle extends Shape {
    protected double width;
    protected double height;
    
    //tại sao em lại để width và height vào đây mà không để vào Shape ?
    //không được vì nếu đặt width và height vào shape thì hình tròn có cạnh à ???

    public Rectangle(String owner, String color, double width, double height) {
        super(owner, color);
        this.width = width;
        this.height = height;
    }
    //super? new Cha = new Shape
    //không đổi vị trí được super xuống dưới, vì nếu tạo con cần tạo cha trước rồi thêm thắt vào
    //super phải là câu lệnh đầu tiên trong phễu

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double getPerimeter() {
        return (width + height) * 2; 
    }

    @Override
    public double getArea() {
        return width*height;
    }

    @Override
    public void paint() {
        String str = String.format("Rectangle     |%-10s|%-10s|%5.2f|%5.2f|%5.2f|%5.2f|", 
                                            owner,color,width,height, getPerimeter(),getArea());
        System.out.println(str);
    }

}
