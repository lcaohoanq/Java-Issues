package data;

public class Rectangle {
    protected double height;
    protected double width;
    protected String color;
    
    //tạo constructor
    
    public Rectangle(double height, double width, String color) {
        this.height = height;
        this.width = width;
        this.color = color;
    }
    
    //tạo getter

    public double getEdgeA() {
        return height;
    }

    public double getEdgeB() {
        return width;
    }

    public String getColor() {
        return color;
    }
    
    public double getRectanglePerimeter(){
        return 2*(height+width);
    }
    
    public double getRectangleArea(){
        return (height * width);
    }
    //method showInfor: paint
    public void paint(){
        String str = String.format("Rectangle   |%5.2f |%5.2f |%s |%5.2f |%5.2f |",
                height,width,color,getRectanglePerimeter(),getRectangleArea());
        System.out.println(str);
    }
    
    
}
