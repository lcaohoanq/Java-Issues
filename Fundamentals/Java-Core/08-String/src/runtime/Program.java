package runtime;

import java.util.StringTokenizer;

public class Program {
    public static void main(String[] args) {
        String lname = new String ("Điệp"); //tạo biến bằng object -> wrapper class (string)
        String tmp  = lname;//con trỏ tmp trỏ(tham chiếu) lname
        
        String fname = "Lê"; //tạo biến trực tiếp -> pool
        
        //String là immutable (bất biến)
        //bất kỳ thao tác nào lên object đều không làm thay đổi giá trị
        //của object mà sẽ tạo ra 1 bản sao object mới 
        //là kết quả thao tác trên bản sao đó
        
        //immutable
        lname.concat(fname);
        System.out.println("lname = "+lname); //lname = Điệp
        //tác động lên lname (wrapper) thì không làm thay đổi nhân của nó
        
        lname = lname.concat(fname);
        //hứng lại giá trị lname sau khi thay đổi
        
        System.out.println("lname = "+lname); //Điệp Lê
        //đây là bản sao khi thao tác lên nó rồi hứng lại
        
        System.out.println("tmp = "+tmp); //Điệp
        //vẫn là core, giá trị gốc không thay đổi =))))))
        
        /*StringBuilder và StringBuffer*/
        
        //2 thằng này là mutable-String
        StringBuilder lname1 = new StringBuilder ("Điệp");
        StringBuilder tmp1  = lname1;//con trỏ tmp trỏ(tham chiếu) lname
        StringBuilder fname1 = new StringBuilder ("Lê"); 
        
        //***String builder không tạo bằng pool được
        
        lname1.append(" ").append(fname1);
        //StringBuilder là mutable
        //nên hành động này sẽ làm lname1 thay đổi
        
        System.out.println(lname1); //Điệp Lê
        System.out.println(tmp1);   //tmp1 = lname1 = Điệp Lê
        
        /*StringTokenizer - hash: băm - split*/
        String information = "SE13029|Điệp đẹp trai|2000|9.9";
        
        StringTokenizer st = new StringTokenizer(information,"|");
        //st như 1 tay đồ tể của mình
        //mình nói chắt là chặt
        
        System.out.println(st.countTokens()); //4 -> 4 khúc
        
        System.out.println(st.hasMoreTokens());//true
        //còn để chặt nữa không?? nếu còn là true
        
        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
            //.nextToken() vừa chặt vừa return khúc đã chặt
            //và mình lấy khúc đã chặt mình in ra màn hình
        }
        
        System.out.println(st.countTokens()); //0, chặt xong rồi
        
        System.out.println(st.hasMoreTokens());//false
        
        System.out.println(information); //SE13029|Điệp đẹp trai|2000|9.9
        //chả bị gì hết vì immutable
        
    }

    // checkStringMethod()   
    public static void checkStringMethod(){
        //Khi dùng method với String phải để ý return 
        //vì String là immutable nên thường method sẽ trả ra String 
        //kết quả ta cần phải hứng
        
        String str1 = "Điệp"; //pool
        String str2 = "Lê";   //pool
        str1= str1.concat(str2).concat("ahihi").concat("Đồ chó");
        System.out.println(str1); //"ĐiệpLêahihiĐồ chó"
        
        //có thể chấm hoài được tới chết
        
        System.out.println(str1.length()); //ĐiệpLêahihiĐồ chó -> 17
        //ta vẫn đang chơi đùa với bản sao này        
        //length(): độ dài
        
        str1 = "Điệp đẹp trai";
        str2 = "đẹp";
        
        //hàm tìm vị trí
        System.out.println(str1.indexOf(str2));//5
        //tìm có tồn tại
        System.out.println(str1.contains(str2)); //true 
        //ký tự ở vị trí
        System.out.println(str1.charAt(9)); //t 
        
    }
    
    //palyWithStringComparision
    public static void playWithStringComparision(){
        String s0 = new String("BÉ HỨA HỌC HÀNH CHĂM NGOAN"); //wrc
        String s1 = "BÉ HỨA HỌC HÀNH CHĂM NGOAN"; //pool
        String s2 = "BÉ HỨA HỌC HÀNH CHĂM NGOAN"; //pool
        String s3 = "bé hứa học hành chăm ngoan"; //pool
        String s4 = new String("BÉ HỨA HỌC HÀNH CHĂM NGOAN"); //wrc
        String s5 = new String("BÉ HỨA HỌC HÀNH CHĂM NGOAN"); //wrc
        
        System.out.println(s0 == s1); //false vì so sánh địa chỉ với nhau
        
        System.out.println(s1 = s2); //true
        
        //đặc điểm của pool nếu mà có chung giá trị thì sẽ tự động
        //2 thằng trỏ một nàng
        //mục đích: giảm thiểu lưu trữ
        //vẫn so sánh địa chỉ nhưng s1 và s2 là pool
        //cùng giá trị nên cùng vùng nhớ
        
        System.out.println(s2 = s3); //false 
        //cùng pool nhưng khác giá trị của nhau 
        
        System.out.println(s4 == s5); //false
        //2 thằng khác địa chỉ
        
        //String là object, so sánh string luôn là so sánh địa chỉ
        //muốn so sánh giá trị của String
        //.equal()   .compareTo()
        
    }
}
