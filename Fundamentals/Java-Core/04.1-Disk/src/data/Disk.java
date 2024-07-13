
package data;


public class Disk {
    private double radius;
    //5 hình tròn xài chung 1 số PI
    //public final double PI = 3.14;
    
    
    public static final double PI = 3.14;
    //static nghĩa là không thuộc sở hữu của object nào hết
    //mà thuộc sở hữu của bộ khuôn
    
    //final: không cho chỉnh sửa => const

    public Disk(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
    
    //số pi không cần getter
    
    //tạo getter
    public double getPerimeter(){
        return 2*PI*radius;
    }
    public double getArea(){
        return PI*Math.pow(radius, 2);
    }
    //method showInfo
    public void paint(){
        String str = String.format("Disk   |%5.2f|%5.2f|%5.2f|", 
                radius, getPerimeter(),getArea());
        System.out.println(str);
    }
}
