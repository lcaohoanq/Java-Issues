package data;


public class Triangle extends Shape {
    
    //tạo thuộc tính riêng -> 3 cạnh
    
    protected double edgeA;
    protected double edgeB;
    protected double edgeC;

    public Triangle(String owner, String color, double edgeA, double edgeB, double edgeC) {
        super(owner, color);
        this.edgeA = edgeA;
        this.edgeB = edgeB;
        this.edgeC = edgeC;
    }

    @Override
    public double getPerimeter() {
        return edgeA + edgeB + edgeC;
    }

    @Override
    public double getArea() {
        double p = getPerimeter()/2;
        return Math.sqrt(p*(p-edgeA)*(p-edgeB)*(p-edgeC));
    }

    @Override
    public void paint() {
        String str = String.format("Triangle      |%-10s|%-10s|%5.2f|%5.2f|%5.2f|%5.2f|%5.2f|",
                                        owner,color,edgeA,edgeB,edgeC,getPerimeter(),getArea());
        System.out.println(str);
    }
    
}
