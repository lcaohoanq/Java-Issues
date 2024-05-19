package runtime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Admin
 */
public class Program {

    
    public static void main(String[] args) {
        
        ArrayList<Student> stList = new ArrayList<>();
        stList.add(new Student("S01", "Hoang", 2004));
        stList.add(new Student("S02", "Duong", 2004));
        stList.add(new Student("S03", "Vy", 2004));
        stList.add(new Student("S04", "Nhi", 2004));
        stList.add(new Student("S05", "Nhu", 2006));
        
        System.out.println("Trước khi sort");
        for (Student item : stList) {
            System.out.println(item.toString());
        }
        
        Comparator<Student> orderById = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //mặc định so sánh là cú pháp ở dưới
                //sẽ so sánh tăng dần 
                //return o1.getId().compareTo(o2.getId()); //
                
                //để xuôi thông số sẽ so sánh theo thứ tự tăng dần dù bất cứ thứ gì
                //để ngược thì so sánh giảm dần, vậy thôi :)
                return o2.getId().compareTo(o1.getId()); //
            }
        };
        
        Collections.sort(stList,orderById);
        System.out.println("Sau khi sort");
        for (Student item : stList) {
            System.out.println(item.toString());
        }
        
    }
    
}
