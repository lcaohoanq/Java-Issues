package readWriteSeparate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class StudentManagement {

    //vấn đề: mình muốn read từ một file và đưa dữ liệu vô một mảng 
    //write ngược lại dữ liệu từ mảng đó vô file 
    public static ArrayList<Student> stList = new ArrayList<>();

    //mặc định khi gọi thằng main này không có gì hết, vì nó là constructor rỗng
    public boolean loadFromFile(String url) {
        try {
            //Hành động load từ file ta sẽ dùng BufferedReader và truyền vào nó một cái File
            BufferedReader br = new BufferedReader(new FileReader(url));

            String line = br.readLine(); //đọc từng dòng của file
            while (line != null) {
                //băm file này ra với StringTokenizer
                StringTokenizer st = new StringTokenizer(line, "-"); //băm thằng line với delim = "-"

                //hứng lại giá trị khi băm
                String name = st.nextToken().trim();
                int age = Integer.parseInt(st.nextToken().trim());
                String address = st.nextToken().trim();
                String phone = st.nextToken().trim();

                //Tạo ra một object để lưu lại thông tin đã băm
                Student stu = new Student(name, age, address, phone);

                //add lại vô arrayList
                stList.add(stu);

                //chú ý: nếu không làm hành động này sẽ bị pending 
                line = br.readLine();
            }
            System.out.println("Read file successfully");
            return true;
        } catch (Exception e) {
            System.out.println("Error load file " + e.getMessage());
            return false;
        }
    }

    //Sử dụng BufferedWriter
    public void writeToFile(String url) {
        if (stList.isEmpty()) {
            System.out.println("Student list is empty");
            return;
        }
        try {
            File file = new File(url);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Student st : stList) {
                //write theo định dạng mà mình mong muốn
                bw.write(st.getName() + "~" + st.getAge() + "~" + st.getAddress() + "~" + st.getPhone());
                bw.newLine();
            }
            bw.close();
            fw.close();
            System.out.println("Writefile successfully");
        } catch (Exception e) {
            System.out.println("Error save to file" + e.getMessage());
        }
    }

    //kiểu sử dụng OutputStreamWriter
    public boolean saveToFile(String url) {
        try {
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(new File(url)));
            //duyệt dữ liệu từ mảng
            for (Student st : stList) {
                osw.write(st.toString()); //write theo định dạng toString mà mình đã override
                osw.write("\n");
            }
            osw.flush();
            System.out.println("Save to file successfully");
            return true;
        } catch (Exception e) {
            System.out.println("Error write file " + e.getMessage());
            return false;
        }
    }
}
