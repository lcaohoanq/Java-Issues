package data;

//khi Student kế thừa Person thì nó sẽ có 

import java.util.Scanner;

//Name, yob, gender
public class Student extends Person{
    //khai báo những gì mà Student cần có
    //props
    private String id;
    private float gpa;
    private String email;

    public Student(String id, float gpa, String email, 
            String name, String gender, int yob) {
        super(name, gender, yob);
        this.id = id;
        this.gpa = gpa;
        this.email = email;
    }
    //super = new cha => new Person(name, gender, yob)

    public Student(){
    }
    
    //getter
    public String getId() {
        return id;
    }

    public float getGpa() {
        return gpa;
    }

    public String getEmail() {
        return email;
    }
    
    //tạo Setter thông minh: nghĩa là nhận vào giá trị
    //nếu giá trị valid thì gán vào ngăn và return true
    //nếu giá trị invalid thì không gán vào ngăn và return false
    public boolean setId(String id) {
        if(id.length() != 0){
            this.id = id;
            return true;
        } else {
            System.out.println("Id is not valid, type again: ");
            return false;
        }
        
    }
    
    //setter thông minh cho gpa
    public boolean setGpa(float gpa) {
        if(gpa >= 0 && gpa <= 10){
            this.gpa = gpa;
            return true;
        } else {
            System.out.println("gpa is not valid, type again");
            return false;
        }
    }
    
    //setter cho email

    public boolean setEmail(String email) {
        //nếu email khác rỗng và chứa dấu "@"
        if(!email.isEmpty() && email.contains("@") ) {
            this.email = email;
            return true;
        } else {
            System.out.println("Email not valid, type again");
            return false;
        }
    }
    
    
    //showInfor -> bổ sung thêm cho cái phễu rỗng
    //nếu không viết showInfor thì sẽ kế thừa của Person
    //nhưng không phù hợp để mention tới một sinh viên (Student)
    //insert code -> Overrdrive: vượt mặt 
    @Override
    public void inputInfor() {
        super.inputInfor(); 
        //input của cha
        //nhập được name, gender, yob
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID: ");
        
        while(!setId(sc.nextLine()));
        
        System.out.println("Nhập gpa: ");
        //this.gpa = sc.nextFloat(); //nếu mà nhập như này là bị trôi thông tin
        //Wrapper.parse + nextLine
        
        while(!setGpa(Float.parseFloat(sc.nextLine())));
        
        System.out.println("Nhập email: ");
        
        while(!setEmail(sc.nextLine()));
    }

    @Override
    public void showInfor() {
        super.showInfor(); 
        //cha đã in ra 3 thông tin
        //mình cần in thêm 3 thông tin nữa
        System.out.printf("|%s|%.2f|%s\n", id,gpa,email);
    }
    
    //thêm method check học bổng
    public boolean hasScholarship(){
        return this.getGpa() >= 8;
    }
}

//constructor rỗng + hàm inputInfor
//Wrapper.parse + nextLine
//setter thông minh, giúp chặn giá trị nhập vào