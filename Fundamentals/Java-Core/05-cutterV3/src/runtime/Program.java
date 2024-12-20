package runtime;

import data.Disk;
import data.Rectangle;
import data.Shape;
import data.Square;
import data.Triangle;
import data.RightTriangle;

public class Program {
    public static void main(String[] args) {
        //tạo 1 cái mảng có thể lưu được rec, square, disk
        Shape ds[] = new Shape[6];
        ds[0] = new Disk("Hoàng", "Đen", 9.9);
        ds[1] = new Rectangle("Hường", "Hồng", 2, 3);
        ds[2] = new Square("Lục", "green", 5);
        
        //tạo gián tiếp
        Disk d = new Disk("Mợ", "Đỏ", 5);
        ds[3] = d;
        
        ds[4] = new Triangle("Ngọc", "Trắng", 3,5,7);
        ds[5] = new RightTriangle("Châu","Đen",3,4);
        
        //in ra mà không có điểm dừng
        for (Shape item : ds){
            item.paint();
        }
        
        //muốn tạo một object cần gì ?
        //cái khuôn (class), cái phễu (constructor)
        //biến con trỏ  = new ???
        //Dog Duy  = new Dog (?,?,?);
        
        //object được tạo từ class con thì sao?
        //y chang luôn, khuôn, phễu, biến con trỏ
        //Square sq = new Square (?,?);
        
        /*
            Tuy nhiên nếu phân tích kỹ vùng nhớ của object con, ta thấy vùng new con có vùng new cha (key: super)
            Mục đích: 
                + giúp cho con có tất cả những gì cha có
                + bản thân thằng con và thằng cha có thể sống độc lập (code mà không cần kế thừa...)
                    + cha giữ những cái chung
                    + con giữ cái riêng
                    + hành động kế thừa là hành động lôi ra những thứ mà cha đã giữ dùm con
                + nhưng để nhận cha con, thì thằng con cho cha những điểm chung và kế thừa là lúc lấy lại những thứ đó
                => KHÔNG CẦN LÀM LẠI NHỮNG ĐIỀU NGƯỜI KHÁC ĐÃ LÀM TỐT
            Phân tích sâu vào object con
                Square s1 = new Square();
                         => new Rectangle() + code riêng của con
        thằng con chính là: new cha()       + code riêng của con
                            super
                            di truyền       + extends (vùng biến dị)
                            inherit
        
        *Nếu cha là abstract class thì sao ?
        object con sẽ nhu nào: new cha + code của riêng con + code cho abs method (vá lỗi)
        bản thân abs class không tạo được object
        nó cần class trung gian để vá lỗ thủng
        nhưng lười, không thích đi qua trung gian mà cứ đòi dùng cái khuôn thủng để đúc ra object
        => Kĩ thuật anonymous / mượn gió bẻ mang
        
        //khi nào dùng anonymous ?
        //khi muốn tạo object từ abs class mà không thông qua class trung gian
        //em đúc ra object từ cái khuôn bị thủng
        
        ưu điểm: 
            + không cần tạo class trung gian (không cần đặt tên)
            + tạo object trực tiếp bằng khuôn thủng
        nhược điểm:
            + mỗi lần đúc là mỗi lần implement (vá)
        */
        
        //vừa đúc vừa vá
        Shape xxx = new Shape("XXX", "Da") {
            @Override
            public double getPerimeter() {
                return 12;
            }
            
            @Override
            public double getArea() {
                return 200;
            }
            
            @Override
            public void paint() {
                String str = String.format("XXX    |-%10s|-%10s|%5.2f|%5.2f|", 
                                            owner, color, getPerimeter(),getArea());
                System.out.println(str);
            }
        }; //class anonymous
        
        //Drift: con trỏ của object
        Rectangle r1 = new Rectangle("R1", "Red", 2, 5);
        //r1 lưu ở stack là con trỏ có nhiệm vụ điều khiển vùng nhớ / trỏ vào vùng nhớ Rectangle
        Square s1 = new Square("S1", "yellow", 4);
        //s1 lưu ở stack là con trỏ có nhiệm vụ điều khiển vùng nhớ / trỏ vào vùng nhớ Square
        
        Rectangle r2 = new Square("R2", "Green", 8);
        //sử dụng con trỏ r2 của hình chữ nhật để điều khiển khuôn hình vuông
        //nếu r2. thì không có được vì phạm vi điều khiển của con trỏ chi nằm trong vùng của cha
        //con trỏ của cha sẽ có phạm vi điều khiển nhỏ hơn của con 
        //nếu lấy con trỏ của cha mà trỏ tới vùng không giao nhau giữa cha con sao mà được
        //khai cha new con
        //=> xài được override method nhưng không xài được hàm riêng của con
        //kĩ thuật Drift: ép kiểu
        //Square tmp = (Square)r2;
        //giờ đây tmp đã dài hơn -> nối được draw title
        //cách viết tắt
        ((Square)r2).draw();
    }
}
