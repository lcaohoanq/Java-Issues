
package data;

//RightTriangle nhận cha gần là Triangle
public class RightTriangle extends Triangle {

    public RightTriangle(String owner, String color, double edgeA, double edgeB) {
        super(owner, color, edgeA, edgeB, Math.sqrt(edgeA*edgeA + edgeB*edgeB));
    }
    
    
    public void paint() {
        String str = String.format("RightTriangle |%-10s|%-10s|%5.2f|%5.2f|%5.2f|%5.2f|%5.2f|",
                                                owner,color,edgeA,edgeB,edgeC,getPerimeter(),getArea());
        System.out.println(str);
    }
    //super = new Cha = new Triangle;
    
}
