package runtime;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        //Regex là gì 
        //Regex | Regular Expression | Pattern | Biểu thức chính quy
        //Mẫu cho string noi theo
        //công dụng: có thể đặt điều kiện cho một chuỗi 
        
        String str = "AE1234567";
        String regex1 = "^[Ss][Ee]\\d{7}"; //Se,SE,sE,se và 7 số đằng sau
        //
        System.out.println(str.matches(regex1));
        //trả về true hoặc false
        
        //1. ký tự cố định 
        //chuỗi mà bạn đưa có phải là name không?
        
        System.out.println(checkString("namec","name")); //kết quả false vì namec khác name
        System.out.println(checkString("name","name")); //kết quả true
        System.out.println(checkString("nAme","name")); //false 
        
        //2. Bỏ qua hoa thường : (?i) : ignoreCase
        
        //đôi khi không quan tâm hoa hoặc thường
        System.out.println(checkString("nAme","(?i)name")); //true
        
    //I.metcharacter symbol
            //1. 1 ký tự bất kỳ (dấu chấm) '.'
        System.out.println(checkString("9name", ".name")); //true
        System.out.println(checkString("m6y", "m.y"));   //true
        //dấu . đại diện 1 ký tự bất kỳ trừ kí tự xuống hàng
        
            //2. lặp lại kí tự trước từ 0 - nhiều lần
        //m*y -> y, my, mmmmy, mmmmmmmy 
        //chữ m được xuất hiện từ 0 đến nhiều lần
        
        //m(er)*y -> my, mery, merererererererery
        //lặp lại chữ er nhiều lần
        
        //=> được quyền xuất hiện hoặc 0 lần hoặc rất nhiều lần
        
            //3.Được quyền xuất hiện hoặc không "?"
        //me?y 
        //chữ e được quyền xuất hiện 1 lần hoặc không xuất hiện
        System.out.println(checkString("my", "me?y"));
        //mey|my true
        //meey   false
    
    //II. Character set
            //1. 1 phần tử bất kỳ trong tập hợp [...]
        //không muốn lấy hết giống như "."
        //m[abc]y -> may, mby, mcy,
        //nhận bất cứ từ gì và không muốn lấy abc thì sao ?
        //m[^abc]y -> cái gì đó sẽ khác abc => ĐẢO NGƯỢC
        //m[\^abc]y -> cái dấu mũ sẽ KHÔNG TÍNH ĐẢO NGƯỢC
        //=> dấu '\' dùng để phá võ công của một kí tự nào đó
        // \: escape character
        //m[^\^abc]y
        
        System.out.println(checkString("may", "m[abc]y")); //true
        
            //2. 1 phần tử bất kỳ khác các phần tử trong tập hợp [^...]
            
            //3. khớp các chữ cái
                //chỉ muốn lấy những chữ cái từ a-z, chạy theo chiều thuân
                //m[a-z]y    : 1 ký tự bất kì từ a - z
                //m[A-Z]y    : 1 ký tự bất kì từ A - Z
                //m[a-zA-Z]y : 1 chữ cái bất kỳ hoa thường đều được
            //4. Khớp số
                //m[0-9]y    : 1 số bất kì từ 0 đến 9
            //5. Giới hạn số lượng ký tự {}
                //ký tự trước đó lặp {lần}
                //     me{2,4}y      : nhận vào chữ e từ 2 đến 4 lần
                //     me{3,}y       : nhận vào chữ e từ 3 trở lên
                //     me{5}y        : chỉ nhận vào 5 chữ e
                //     m(e{2}|e{4})y : chỉ nhận vào 2 hoặc 4 chữ e
                //     {0,}          : *
                //     {1,}          : +
                //     {0,1}         : ?
            //6. group: gom nhóm ();
            //7. hoặc '|'; thường đi chung với ngoặc tròn
                //toi (co|khong) dep trai -> toi co dep trai hoac toi khong dep trai
                System.out.println(checkString("meey", " m(e{2}|e{4})y")); //true
            
            //format tên: ([A-Z][a-z]*)( [A-Z][a-z]*)*
            //([A-Z][a-z]*)   : 1 ký tự viết hoa và nhiều kí tự viết thường tạo thành 1 từ
            //( [A-Z][a-z]*)* : 1 dấu cách chung với (nhiều) ký tự viết hoa và viết thường
            
    //III-shortHand: viết tắt
            //1. khớp chữ cái hoặc số \w  => [a-zA-Z0-9]   \W: phủ định
            //2. khớp với số          \d  => [0-9]         \D: phủ định
            //3. khớp với space       \s                   \S: phủ định
            //vd: ([A-Z][a-z]*)(\s[A-Z][a-z]*)* 
    
    //Try catch: 2 lỗi phổ biến hay gặp
        //error compilation: lỗi trong quá trình biên dịch
        //Nguyên nhân      : Do mình 
        
        //error logic      : sự ngu dốt không phải là lỗi
        
        //error runtime    : lỗi phát sinh trong lúc chạy code
        
        //lỗi của mình nhưng không phải do mình tạo
        
        //scanf
        //trong java mình có 1 class chuyên dùng để nhập
        //Scanner : chuyên cung cấp các method để nhập
        
        Scanner sc = new Scanner(System.in);
        int age = 0;
        //Nhap
        //dùng try: anh ơi anh xem thử nè chbi chó người dùng nhập nè
        try{
            System.out.println("Nhap tuoi di:  ");
            age = sc.nextInt();
            //neu muon gioi han so tuoi
            if(age < 10 || age > 30){
                throw new Exception();
            }            
        } catch(Exception e){
            System.out.println(e);
        } 
        //in ket qua
        System.out.println("Tuoi ne: "+age);
        
    }
    //viết thêm 1 cái hàm
    //nhận vào cái chuỗi và cái regex
    //trả ra kết quả so sánh chuỗi và regex
    //đúng hoặc sai
    public static boolean checkString(String str, String regex){
        return str.matches(regex);
    }
}
