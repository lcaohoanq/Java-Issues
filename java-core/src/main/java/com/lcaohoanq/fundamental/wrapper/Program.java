package com.lcaohoanq.fundamental.wrapper;

public class Program {

    public static void main(String[] args) {
        int a = 10; //primitive: 4byte 4*8bit
        //biểu diễn trong thanh ram để hiển thị số
        //a. là không được vì quá nhỏ 

        //Wrapper Class
        Integer b = new Integer(10);
        //new Integer(10) ; là tạo 1 object và nhét số 10 vào 
        //core(lõi) của object đó
        //b là con trỏ để trỏ object có lõi bên trong là 10

        //a khác gì b?

        //a là biến primitive, bản thân đã rất nhỏ
        //      nó không thể tách nhỏ hơn được nữa
        //      =>nhỏ nên chiếm ít dung lượng

        //b là 1 object có core là 10, tức là ngoài việc nó
        //lưu số 10, nó còn lưu method, bla bla
        //      => chiếm nhiều dung lượng
        //      => nhưng có nhiều method hỗ trợ cho số 10
        //      => ép kiểu....

        //Integer b new Integer(10)
        //gói con số 10 vào 1 object
        //=> boxing: đóng gói

        //boxing diễn ra khi Wrapper Class = primitive

        System.out.println("a = " + a); //a = 10

        System.out.println("b = " + b); //b = 10
        //bản thân thằng b là một object(con trỏ) không lưu giá trị
        //lưu địa chỉ dẫn tới object có lõi bên trong, giá trị là 10

        //NẾU ĐÚNG RA IN B CHỈ IN ĐƯỢC ĐỊA CHỈ ~987897235....

        //NHƯNG JAVA CÓ CƠ CHẾ AUTO-UNBOXING
        //nên là nó tự động mở object b lấy ra core(10) để dùng
        //máy tính sẽ hiểu chúng ta làm như sau
        System.out.println("b = " + b.toString());

        int c = b; //c = 10 
        //tại sao primitive lại = wrapper ?
        //vì cơ chế auto-unboxing
        // mở object b ra đưa core cho c

        System.out.println("c = " + c); //c = 10

        //ngoài ra ta có thể viết tắt
        //Integer d  = new Integer(2000);
        //thành
        Integer d = 2000; //Pool

        System.out.println("d = " + d); //2000
        //auto-unboxing
        //nếu không có cơ chế này thì in ra địa chỉ

        System.out.println("sum = " + (a + d)); //2010
        //nếu không có cơ chế auto-unboxing 
        //kết quả = 10 + địa chỉ

        //wrapper class được hỗ trợ cơ chế auto-unboxing
        //nên việc giao tiếp, tính toán, trao đổi với primitive
        //diễn ra bình thường, không cần lưu ý gì cả

        a = 2000; //primitive
        b = 2000; //wrapper
        d = 2000; //wrapper

        System.out.println(a == b); //true
        //wrapper class so với primitive
        //thì wrapper class auto-unboxing lấy core ra so sánh
        //so sánh giá trị bằng nhau

        System.out.println(b == d); //false
        //wrapper so với wrapper thì là 2 object so với nhau
        //nó sẽ so sánh với nhau bằng địa chỉ => FALSE

        //Vậy muốn 2 wrapper class (2 object) so sánh về giá trị
        //.equal()   -> (t|f)          
        //.compareTo -> (1,0,-1)

        System.out.println(b.equals(d)); //True
        System.out.println(b.compareTo(d)); //Bằng nhau => 0
    }
}