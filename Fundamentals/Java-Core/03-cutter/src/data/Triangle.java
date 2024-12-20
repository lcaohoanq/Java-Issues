package data;
//chế ra cái khuôn chuyên đúc ra các hình tam giác
public class Triangle {
    //khong de public vi khong muon de nguoi dung choc thang vao bo nho
    //neu muon truy cap vao bo nho phai theo y cua minh
    protected double edgeA;
    protected double edgeB;
    protected double edgeC;
            
    //private double perimeter = edgeA + edgeB + edgeC
    //có 3 cái khuôn
    //thuộc tính nào nên được biểu diễn và không ?
    //không nên lưu trữ chu vi hay thuộc tính vì (vi phạm tính đồng bộ)
    //1. nếu mình tạo ra nó và mình lưu trữ nó thì nó sẽ có getter và setter
    //=> sẽ có người chỉnh sửa giá trị của chu vi
    
    //2.diện tích hay chu vi có thể tính được từ 3 cạnh trước đó 
    //nên không cần lưu, khi nào cần thì tính
    //tạo phễu: tạo constructor -> phải public, tên trùng với class, 
                                   //không có đầu ra
    
    //đặt cùng tên thì sẽ khó bị phân biệt -> this.
    //ý nghĩa: Triangle ơi hãy chỉ đến edgeA và cho nó bằng edgeA
    
    public Triangle(double edgeA, double edgeB, double edgeC ){
        this.edgeA = edgeA;
        this.edgeB = edgeB;
        this.edgeC = edgeC;
    }
    
    //ban đầu đã private nên không có khả năng get và set
    //viết một hàm có khả năng get (người dùng lấy được giá trị ra) mở ra nhưng
    //không có khả năng set

    public double getEdgeA() {
        return edgeA;
    }

    public double getEdgeB() {
        return edgeB;
    }

    public double getEdgeC() {
        return edgeC;
    }
    //getchuvi
    //những thuộc tính nào tính được thì bỏ trong get
    //giải quyết được vấn đề bất đồng bộ
    public double getPerimeter() {
        return edgeA + edgeB + edgeC;
    } 
    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - edgeA) * (p - edgeB) * (p - edgeC));
    }
    //method showInfor:
    public void showInfor(){
        String str = String.format("Triangle |%5.2f |%5.2f |%5.2f |%5.2f |%5.2f"
                , edgeA, edgeB, edgeC, getPerimeter(), getArea());
        System.out.println(str);
    }
}
