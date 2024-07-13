package runtime;
//muốn lưu trữ hình chữ nhật và hình vuông
//Rectangle (height, width, color)

import data.Rectangle;
import data.Square;
//Square 
//Square is a Rectangle
// con          cha

public class Program {
    public static void main(String[] args) {
        Rectangle  re1 = new Rectangle(2, 5, "Tím");
        Square     sq1 = new Square(5,"Hường");
        
        Rectangle re2 = new Square(6, "Đỏ");
//         đúc hình vuông từ khuôn hình chữ nhật => OK
//        Square     sq2 = new Rectangle(0,0,color); => SAI
//          

        //Square ds[] = new Square[3]; // tạo danh sách chỉ chứa những hình vuông
        //thay vì đó lấy cha sẽ ok hơn
        Rectangle ds [] = new Rectangle[3];
        ds[0] = re1;
        ds[1] = sq1;
        ds[2] = re2;
    
//        for cùi
        for (int i = 0; i <= ds.length - 1; i++) {
            ds[i].paint();
        }
        
        //fore: for each -> không ngừng, chạy hết kể cả return
        for (Rectangle item : ds) {
            //item là ds[0] ds[1].....
            item.paint();
        }
    }
}
