package runtime;

import data.StudentV1;
import data.StudentV2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Program {

    public static void main(String[] args) {
        //sortV1(); //function call
        sortV2();
    }
    public static void sortV1(){ //create function
        //sortV1 mình sẽ sort danh sách sinh viên bth,
        //bằng cách dùng comparator(anh trọng tài)
        ArrayList<StudentV1> stuList = new ArrayList<StudentV1>();
        stuList.add(new StudentV1("SE00001", "Lê"    , "An"   , 8.2));
        stuList.add(new StudentV1("SE00005", "Nguyễn", "Bình" , 7));
        stuList.add(new StudentV1("SE00002", "Lý"    , "Dũng" , 9));
        stuList.add(new StudentV1("SE00004", "Trần"  , "Cường", 7.5));
        stuList.add(new StudentV1("SE00003", "Võ"    , "Em"   , 9.9));
        
        //giờ muốn sort, mình có thể dùng comparator
        //comparator: là 1 anh trọng tài, đứng ra xem xét 2 đối tượng 
        //bất kì trong mảng
        //dựa trên 1 tiêu chí nào đó
        
        //comparator: là 1 interface có abs method là comparator
        //      nếu tạo 1 trọng tài ta cần bổ sung code cho comparator
        //      nói cách khác dạy cho anh trọng tài cách so sánh
        
        //cách 1    : TẠO RA COMPARATOR TRƯỚC RỒI DÙNG ẢNH ĐỂ SO SÁNH
        
        Comparator ordById = new Comparator<StudentV1>() {
            @Override
            public int compare(StudentV1 t1, StudentV1 t2) {
                if(t1.getId().compareTo(t2.getId()) > 0){
                    return 1;
                } 
                return -1;
            }
        };
        //in ra xem
        Collections.sort(stuList, ordById);
        for (StudentV1 item : stuList) {
            item.showInfor();
        }
        
        //Cách 2: shortHand
        Collections.sort(stuList, new Comparator<StudentV1>() {
            @Override
            public int compare(StudentV1 t1, StudentV1 t2) {
                if(t1.getId().compareTo(t2.getId()) > 0){
                    return 1;
                } 
                return -1;
            }
        });
        //in ra xem
        for (StudentV1 item : stuList) {
            item.showInfor();
        }
    }
    public static void sortV2(){
        ArrayList<StudentV2> stuList = new ArrayList<StudentV2>();
        stuList.add(new StudentV2("SE00001", "Lê"    , "An"   , 8.2 ));
        stuList.add(new StudentV2("SE00005", "Nguyễn", "Bình" , 7   ));
        stuList.add(new StudentV2("SE00002", "Lý"    , "Dũng" , 9   ));
        stuList.add(new StudentV2("SE00004", "Trần"  , "Cường", 7.5 ));
        stuList.add(new StudentV2("SE00003", "Võ"    , "Em"   , 9.9 ));
    
        Collections.sort(stuList);
        
        for (StudentV2 item : stuList) {
            item.showInfor();
        }
    }
}
