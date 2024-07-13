package runtime;

import data.Star;

public class Program {
    public static void main(String[] args) {
        //tạo thử anh Sơn Tùng
        Star mtp = new Star("Nguyen Thanh Tung", 1994, "Nam", 
                            "Cơn mưa ngang qua");
        //new Star chính là gọi cái phễu Star
        mtp.showInfor();
        //tạo thêm Chipu
        Star chipu = new Star("Nguyễn Thùy Chi", 1993, "Nữ", "Chiếc ố");
        chipu.showInfor();
        
        //getter và setter
        //mtp.name = "Tùng Sơn"; //set, vì mtp để public name nên sửa được
        //System.out.println("Tên của mtp là "+mtp.name); //get
        //biện pháp là chuyển name thành private -> bị chặn 2 đầu
        //không ổn khi cần lấy tên ra để sử dụng
        
//      Đúng pass = 1, thì sẽ đổi tên thành Lệ Rơi
        mtp.setName("Lệ Rơi", 3);
        System.out.println("Tên của mtp là "+ mtp.getName());
        
        //thêm static cho gender
        //quản lí ngọc trinh
        Star ngoc = new Star("Trần Thị Ngọc Trinh", 1989, "Nữ", "Vòng 56");
        ngoc.showInfor();
        Star diep = new Star("Lê Mười Điệp", 1999, "Nam", "a++ + ++a");
        diep.showInfor();
        System.out.println("Dạ em là "+ ngoc.gender);
    }
}
/*Lý thuyết Modifier

     + Đối với class  : có 2 loại access-modifier (public - default)
     + Biến và method : 4 loại (public, private, protected, default)

1. Access Modifier (phạm vi truy cập)

    +Public   :  phạm vi truy cập rộng nhất, trong cùng project, chỉ cần gọi là được

    +Private  : + phạm vi truy cập chỉ trong class chứa nó, bất kì nơi nào khác không được
                + (class và interface không thể là private)
                + có thể được truy cập nếu như có tạo method getter, setter cho biến private đó tại class đó

    +Protected: + phạm vi truy cập trong cùng một package (và ngoài package thông qua kế thừa)
                + không thể áp dụng cho class và inteface
                + các method và props khác có thể protected trừ chúng ở interface
    
    +Default  : + phạm vi trong pks
                + nếu không khai báo một access modifier nào -> mặc định là default

2. Non - access modifier

    +Final: class, method, props
        final class: không có khả năng nhận thằng khác làm con
                    +không thể extend từ class khác 

        final method: method này có di truyền không override được

        final props: tạo một biến là hằng số (constant)

        +inteface không thể định nghĩa final -> vì interface cần một class khác thực hiện nó
    
    +Static: tĩnh (đứng yên tại chỗ)

        sử dụng chung cho tất cả các đối tượng

        vd: class Student (name, yob, mark, roomName = Diep) 

    +Abstract: trừu tượng
        abstract method: hành động chưa định nghĩa

        class bth mà chứa abstract method thì nó là abstract class

        abstract class không nhất thiết phải có abstract method
        
        +không thể tạo obj từ abstract class
        +một inteface mặc định sẽ là abstract class

class cha (){
    abstract method thành công ()
    abstract method ăn trứng ()
    abstract method yêu ()
}
//== bán trà sữa
class cha (){
    final method nấu trà sữa (){
        nấu cực ngon bằng than tre
    }
}
class con (){
    override: vượt mặt
    method nấu trà sữa (){
        nấu cực ngon bằng than tre
        đường hóa học, ma tóe
    }

    ****overload: các hàm cùng tên nhưng thực hiện chức năng khác nhau
}

//==
class tạo ra object
class có thể nhận 1 class khác làm con
*/