
package com.lcaohoanq.fundamental.datatype;


public class DataType {
    public static void main(String[] args) {
        //comment: ghi chú
        /*
            trong java có 2 kiểu dữ liệu
    1. primitive datatype: kiểu dữ liệu nguyên thủy
            dùng một lượng nhỏ bộ nhớ để biểu diễn giá trị
        -> không thể chia nhỏ nữa
            đặt tên: cammelCase
            8 loại
            1.byte        1byte       số nguyên rất rất nhỏ (-128 -> 127)
            2.short       2byte       số nguyên rất nhỏ ()
            3.int         4byte       số nguyên nhỏ
            4.long        8byte       số nguyên lớn
            5.float       4byte       số thực nhỏ
            6.double      8byte       số thực lớn
            7.char        2byte       ký tự (unicode)
            8.boolean     1bit        true | false            
        */
        //in ra màn hình
        System.out.println(""); //in xuống dòng
        System.out.printf(""); //format
        
        
        //-----------test %c và %d
        char demoChar1 = 'A';
        System.out.println("C chứa " +demoChar1); 
        
        char demoChar2 = 65; //như nhau
        System.out.println("B chứa " +demoChar2); 
        //-------------------------------------------------------------
        char c = 65;
        //muốn in ra chữ A
        System.out.printf("C là %c \n ", c); //format 
        
        //muốn in ra 65
        //System.out.printf("C chứa %d ", c); //khong in duoc
        
        //fixed
        System.out.printf("C là %d \n ", +c); //65
        
        //-------------------------------------------------------------
        
        //byte: là 1 số nguyên rất nhỏ
        byte numByte = 127;
        //int 
        int numInt = 1234;
        //float
        float numFloat = 123.4f;
        //java ưu tiên số thực là double -> nên java thấy 123.4 là double
        //double sẽ không bỏ vào được float
        //khắc phục bằng viết thêm chữ f
        double numDouble = 123.4D;
        //
        float numF; //thằng này chứa gì ? 0F
        
        //sử dụng biến
        //gán biến nhỏ vào biến lớn mà không ngược lại
        numInt = numByte;
        //numByte = numInt;
    
    //2. reference datatype: Wrapper & object datatype
    //kiểu dữ liệu do người dùng định nghĩa
    //chế bằng các primitive
    //student(name(char-string), yob(int), point(float))
    
    //***hackingPrimitive
    /*
        java ưu tiên số nguyên là int (còn số thực là double)
    */
        long money = 10_000_000_000_000l;
    //long money = 10_000_000_000_000; bị lỗi
        System.out.println("money = "+ money);
        int num1 = 0xFA; 
    //máy sẽ hiểu các kí tự đằng sau viết bằng hexa
    //0x: tiền tố (prefix) ám chỉ số nguyên biểu diễn là dạng hexa(16)
        
        int num2 = 076;
    //0 là tiền tố ám chỉ octal (8)
    //System.out.println("num2 là " +num2);
    
    //operator: toán tử
    //trong java có ít nhất 10 loại toán tử
    //Arithemic: toán tử toán hạng
    // + - * / % ++ --
    // += -= *= /= %=
    int a = 10;
    int b = ++a + a++ - --a + a--;
    System.out.println("b = " + b + ",a = " +a);
    
    //assignment: phép gán
    
    //comparision: phép so sánh
    // > < >= <= != ==
    //logic: and(&&) or (||)
    //&&: đi tìm false
    //||: đi tìm true
    //& và | 
    
    //conditional :toán tử ba ngôi (ternary operator)
    //var  = condition ? true : false
    
    int numA = 10;
    int numB = 20;
    int numC = numA > numB ? 5 : 7;
    System.out.println("c = " +numC);
    
    //String
        // comma: phẩy
        // unary: một ngôi
        // Relational: quan hệ

        // Shift: dịch bit
        //đẩy xuống thì rớt | đẩy về thì bù 0
        int numR = 8;
//        numR = numR >> 2;
//        numR = numR << 2;
        //n >> x => n/(2^x)
        //n << x => n*(2^x)
    
    //bitwise: toán tử bit (&, |, ^, ~)
    //&: có 0 thì tất cả là 0, ngược lại thì 1
    //|: có 1 thì tất cả là 1, ngược lại là 0
    //^: 2 số khác nhau thì ra 1, giống nhau thì 0
    //~: not, đổi ngược
    
    // 0 1 1 0 1 0
    //&.            
    // 0 1 0 1 0 0
    // 0 1 0 0 0 0
    
    // 0 1 1 0 1 0
    //|.            
    // 0 1 0 1 0 0
    // 
    
    // 0 1 1 0 1 0
    //^.            
    // 0 1 0 1 0 0
    // 
    
    // 0 1 1 0 1 0
    //~.            
    // 0 1 0 1 1 0
    }
}
