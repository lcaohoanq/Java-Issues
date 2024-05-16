package runtime;

import data.Person;
import data.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
    /*
        //tạo 1 person
        Person nguoi1 = new Person();
        nguoi1.inputInfor();
        nguoi1.showInfor();
        //không muốn nhập tay mà bắt người dùng nhập -> Scanner
    */

    //tạo 1 Student
    /*
        Student s1 = new Student();
        s1.inputInfor();
        s1.showInfor();
    */
        //Student ds[] = new Student[];
        //có một cái nhược điểm rằng mảng phải cố định
        //mảng không co dãn được
        
        //ArrayList: 1 thằng mảng có khả năng co dãn
        ArrayList<Student> studentList = new ArrayList<>();
        //studentList là mảng chứa các student được tạo
        //bằng ArrayList
        
        int choose; //lưu lựa chọn của người dùng
        //tạo 1 cái menu
        do {
            //showMenu
            showMenu();
            
            //getChoose
            Scanner input = new Scanner(System.in);
            System.out.println("Nhập lựa chọn: ");
            //choose = input.nextInt(); bị trôi lệnh
            //khắc phục -> parse
            choose = Integer.parseInt(input.nextLine());
            
            switch(choose){
                case 1:{
                    System.out.println("-----Tạo 1 sinh viên-----");
                    //import class Student vào
                    Student newStudent = new Student();
                    //nhập vào
                    newStudent.inputInfor();
                    studentList.add(newStudent);
                    System.out.println("Adding Successful");
                    break;
                }
                case 2:{
                    System.out.println("-----Hiển thị thông tin sinh viên-----");
                    //gọi for each -> fore
                    for (Student item : studentList) {
                        item.showInfor();
                    }
                    break;
                }
                case 3:{
                    System.out.println("-----Sinh viên có điểm cao nhất và thấp nhất-----");
                    //giả định
                    float max = studentList.get(0).getGpa();
                    float min = studentList.get(0).getGpa();
                    //đi tìm
                    for (Student item : studentList) {
                        if(item.getGpa() > max) max = item.getGpa();
                        if(item.getGpa() < min) min = item.getGpa();
                    }
                    //in kết quả
                    System.out.println("Những người cao điểm nhất");
                    for (Student item : studentList) {
                        if(item.getGpa() == max){
                            item.showInfor();
                        }
                    }
                    System.out.println("Những người thấp điểm nhất");
                    for (Student item : studentList) {
                        if(item.getGpa() == min){
                            item.showInfor();
                        }
                    }
                            
                    break;
                }
                case 4:{
                    System.out.println("-----Tìm kiếm theo mã sinh viên-----");
                    System.out.println("Nhập vào mã sinh viên cần tìm");
                    String key = input.nextLine();
                    //giả định 
                    boolean isFind = false;
                    for (Student item : studentList) {
                        if(key.equals(item.getId())){
                            item.showInfor();
                            isFind = true;
                        }
                    }
                    if (!isFind){
                        System.out.println("Không có sinh viên đó");
                    }
                    break;
                }
                case 5:{
                    //bản chất hành động sắp xếp là so sánh
                    //equal: bằng nhau hoặc không bằng nhau
                    //compared to: lớn bé bằng
                    System.out.println("-----Sắp xếp sinh viên theo tên asc và hiển thị-----");
                    Collections.sort(studentList, new Comparator<Student>() {
                        @Override
                        public int compare(Student t1, Student t2) {
                            if(t1.getName().compareTo(t2.getName()) > 0){
                                return 1;
                            }
                            return -1;
                        }
                    });
                    //in kết quả
                    for (Student item : studentList) {
                        item.showInfor();
                    }
                    break;
                }
                case 6:{
                    //sort studentList theo điểm
                    System.out.println("------Hiển thị sinh viên được học bổng từ cao xuống thấp giảm dần-----");
                    Collections.sort(studentList, new Comparator<Student>() {
                        @Override
                        public int compare(Student t1, Student t2) {
                            if(t1.getGpa() > t2.getGpa()){
                                return 1;
                            }
                            return -1;
                        }
                    });
                    //đảo ngược mảng lại
                    Collections.reverse(studentList);
                    
                    //in ra theo thứ tự giảm dần
                        /*
                        for (Student item : studentList) {
                            item.showInfor();
                        }
                        */
                        
                    //in thông tin những student có getGpa >= 8 thì mới showInfor
                    for (Student student : studentList) {
                        if(student.hasScholarship()){
                            student.showInfor();
                        }
                    }
                    
                    break;
                }
                case 7:{
                    System.out.println("See you again");
                    break;
                }
                default:{
                    System.out.println("Out of range");
                    break;
                }
            }
            //thực thi lựa chọn
        } while (choose != 7);
        
    }
    public static void showMenu(){
        System.out.println("1.Nhập vào 1 sinh viên ");
        System.out.println("2.Hiển thị thông tin sinh viên ");
        System.out.println("3.Hiển thị sinh viên theo ít điểm nhất và cao điểm nhất ");
        System.out.println("4.Tìm kiếm theo mã sinh viên ");
        System.out.println("5.Sắp xếp sinh viên theo tên asc và hiển thị ");
        System.out.println("6.Hiển thị sinh viên được học bổng từ cao xuống thấp giảm dần");
        System.out.println("7.Thoát ");
    }
}
