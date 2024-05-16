package runtime;
//có nhu cầu là lưu trữ các hình tam giác
//chế ra kiểu dữ liệu mới là tam giác (chế cái khuôn để đúc - class)

import data.RightTriangle;
import data.Triangle;

public class Program {
    public static void main(String[] args) {
        //tạo tam giác đầu tiên
        //gõ Triangle ctrl + space enter -> tự import vào data.Triangle
        Triangle tr1 = new Triangle(1, 2, 4);
        //new Triangle ? đang sử dụng cái phễu Triangle
        tr1.showInfor();
        
        //muốn lưu tam giác vuông thì sao ?
        //cần phễu lưu 2 cạnh từ người dùng thôi, tránh người dùng nhập sai
        //Triangle tr2 = new Triangle(3, 4, 5);
        //tạo cái khuôn tam giác vuông -> ok nhưng chỉ phù hợp với số đẹp
        RightTriangle rtr1 = new RightTriangle(3,9);
        rtr1.showInfor();
        //tên của rightTriangle bị kế thừa tên của bố ? không hợp lí
        //con đã bị kế thừa tên của bố
    }
}
