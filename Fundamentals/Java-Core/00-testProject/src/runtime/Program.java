package runtime;

import data.Student;
import java.util.Scanner;

public class Program {

    //không tạo gì là default
    int sum(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Program p = new Program();
        int s = p.sum(10, 20);
        System.out.println(s);

        System.out.println("5 + 5 = " + (5 + 5));

        Student stu = new Student();
        stu.in
        
    }

    public static void inputStudent() {
        String id;
        Scanner sc = new Scanner(System.in);

        System.out.println("Input id");
        id = sc.nextLine();
        
        System.out.println("Student id: "+id);
    }
    
}
