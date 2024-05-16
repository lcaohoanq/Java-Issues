package data;


public class Disk extends Shape {
    private double radius;
    public final static double  PI = 3.14;

    public Disk(String owner, String color, double radius) {
        super(owner, color);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
    
    //vá lỗ hổng
    @Override
    public double getPerimeter() {
        return 2*PI*radius;
    }

    @Override
    public double getArea() {
        return PI*Math.pow(radius, 2);
    }

    @Override
    public void paint() {
        String str = String.format("Disk          |%-10s|%-10s|%5.2f|%5.2f|%5.2f|", 
                                        owner,color,radius,getPerimeter(),getArea());
        System.out.println(str);
    }
    
    
    
}
