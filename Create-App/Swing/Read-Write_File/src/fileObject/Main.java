package fileObject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

    public static void main(String[] args) {
        Student st = new Student("hoang", 1, "dafsd", "asdfasf");
//        serialize(st);
        deserialize();
    }

    public static void serialize(Student student) {
        try {
            FileOutputStream fileOut = new FileOutputStream("./src/student1.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(student);

            out.close();
            fileOut.close();
            System.out.println("Save object successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deserialize() {
        try {

            FileInputStream fileInput = new FileInputStream("./src/solution.dat");
            ObjectInputStream input = new ObjectInputStream(fileInput);
//readObject trả về một Object nên cần ép về kiểu Employees
            Student student = (Student) input.readObject();

            System.out.println("Read object from File:");
//Hiện thông tin
            System.out.println(student.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
