package data;

public class Square extends Rectangle{
    //hình vuông hay hình chữ nhật đều có chiều cao và chiều rộng
    //vì chiều cao = chiều rộng nên không phân biệt được
    
    public Square(double edge, String color) {
        super(edge, edge, color);
    }

    //super = new Cha = new Rectangle
    // hàm paint bị cấn cái tên của cha -> sửa lại tên trong paint -> cop paint vào con
    //vẫn bị báo lỗi -> do truyền giá trị sai 
    //để protected cho kiểu khai báo của cha
    public void paint() {
        String str = String.format("Square   |%5.2f |%5.2f |%s |%5.2f |%5.2f |",
                height,width,color,getRectanglePerimeter(),getRectangleArea());
        System.out.println(str);
    }
}
