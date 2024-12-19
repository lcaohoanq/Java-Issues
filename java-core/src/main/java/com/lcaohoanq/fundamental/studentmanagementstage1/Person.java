package com.lcaohoanq.fundamental.studentmanagementstage1;

import java.util.Scanner;

public class Person {
    //props
    private String name;
    private String gender; 
    private int yob; 
    
    //constructor: tạo phễu để hứng dữ liệu cho 3 ngăn props
    //có thể tạo bất kỳ số phễu mình cần
    public Person(String name, String gender, int yob) {
        this.name = name;
        this.gender = gender;
        this.yob = yob;
    }
    /*
    public Person(String name, String gender ) {
        this.name = name;
        this.gender = gender;
    }
    */
    public Person() { //overload: cùng tên nhưng khác cái tham chiếu
        //cái phễu rỗng
    }
    //getter
    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getYob() {
        return yob;
    }
    //method showInfor
    public void showInfor(){
        System.out.printf("%s|%s|%s", name,gender,yob);
    } //anh Điệp cố tình không xuống hàng
    
    //Viết hàm nhập giá trị cho các ngăn
    public void inputInfor(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Nhập tên");
        this.name = sc.nextLine(); //nextLine sẽ cho nhập chuỗi
        
        System.out.println("Nhập giới tính");
        this.gender = sc.nextLine();
        
        System.out.println("Nhập năm sinh");
        this.yob = sc.nextInt();
    }
}

//Kết hợp constructor rỗng + hàm inputInfor
//để tạo ra object chưa có giá trị và nhờ người dùng nhập vào