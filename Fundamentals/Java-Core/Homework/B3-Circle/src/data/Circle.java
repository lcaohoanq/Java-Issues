
package data;

//hình tròn cần bán kính
//suy ra được những cái như -> đường kính, chu vi, diện tích, màu sắc ?
public class Circle {
    private double radius;
    private String color;

    public Circle(double radius, String color) {
        this.radius = radius;                   
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }
    
    public double getPerimeter(){
        return Math.PI*2*radius;
    }
    
    public double getArea(){
        return Math.PI*Math.pow(radius, 2);
    }
    
    public void show(){
        String str = String.format("Circle: |Bk %5.2f|Mau %s|Cv %5.2f|Dt %5.2f|",
                                                radius,color,getPerimeter(),getArea());
        System.out.println(str);
    }
}
