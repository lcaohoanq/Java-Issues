/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package runtime;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/*
 Có 3 kiểu đọc ghi file: byte stream, character stream và buffered stream

    - Các chương trình sử dụng Byte Stream để đọc ghi dữ liệu theo từng byte(8bit). 
    Tất cả các class Byte Stream có nguồn gốc từ InputStream và OutputStream.

    - Character Stream trong Java được sử dụng để thực hiện input và output cho Unicode 16 bit. 
    Tất cả các class Character Stream có nguồn gốc từ Reader và Writer. (thường hay sử dụng FileReader và FileWriter)

    - Các ví dụ trên không sử dụng Buffered Streams, điều này có nghĩa là việc đọc và xuất dữ liệu 
    được thực hiện trực tiếp dưới quyền điều khiển của hệ điều hành, 
    gây lãng phí thời gian và tài nguyên. Để giảm thiểu những trên, Buffered Streams đã được sinh ra
        Buffered Streams được sử dụng để tăng tốc độ hoạt động I/O, bằng cách đơn giản là tạo ra một khoảng nhớ đệm 
    với kích thước cụ thể nào đó. Vì vậy chúng ta không cần phải truy cập vào ổ đĩa cứng khi thực hiện I/O. 
    Một chương trình có thể chuyển đổi từ không sử dụng buffered stream 
    (Byte Stream và Chracter Stream sang sử dụng buffered stream bằng việc sử dụng ý tưởng "Wrapping".
                1. Lớp wrapper cho byte stream
                        BufferedInputStream
                        BufferedOutputStream
                2. Lớp wrapper cho character stream
                        BufferedReader
                        BufferedWriter
 */
public class Program {

    public static void main(String[] args) throws IOException {
//        CopyFileByte();
//        CopyFileCharacter();

        String url = "C:\\Users\\Admin\\Desktop\\hoanglcse181513.dat";

        
        
        BufferedReader r = null;
        
        
        try {
            Reader inp = new FileReader(new File(url));
            
            r = new BufferedReader(inp);
            
            String s;
            while((s = r.readLine()) != null){
                System.out.println(s);
            }
            System.out.println("File Read Succsessfull");
        } finally {
            if(r != null){
                r.close();
            }
            
        }
        
    }

    public static void CopyFileByte() throws IOException {
        String inp = "D:\\PIED\\JAVA\\Java Project\\Read-Write_File\\src\\input\\demoByteStream.txt"; //14KB
        String oup = "D:\\PIED\\JAVA\\Java Project\\Read-Write_File\\src\\output\\demoByteStream.txt";

        FileInputStream inputStream = null; //liên kết thằng này trong cụm catch

        FileOutputStream outputStream = null; //liên kết thằng này trong cụm catch

        try {
            File f = new File(inp);

            File o = new File(oup);

            inputStream = new FileInputStream(f);
            outputStream = new FileOutputStream(o);

            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }

        } catch (Exception e) {
            throw new IOException("File loi roi");
        } finally {
            if (inputStream != null) {
                inputStream.close();

            }
            if (outputStream != null) {
                outputStream.close();
            }
            System.out.println("File Write Successfully at " + oup);
        }

    }

    public static void CopyFileCharacter() throws IOException {
        String inp = "D:\\PIED\\JAVA\\Java Project\\Read-Write_File\\src\\input\\demoCharacterStream.txt"; //14KB

        String oup = "D:\\PIED\\JAVA\\Java Project\\Read-Write_File\\src\\output\\demoCharacterStream.txt";

        FileReader fileReader = null;
        FileWriter fileWriter = null;

        try {

            File i = new File(inp);
            File o = new File(oup);

            fileReader = new FileReader(i);
            fileWriter = new FileWriter(o);

            int c;
            while ((c = fileReader.read()) != -1) {
                fileWriter.write(c);
            }

        } catch (Exception e) {
            throw new IOException("File loi roi");
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
            if (fileWriter != null) {
                fileWriter.close();
            }

            System.out.println("File Write Successfully at " + oup);

        }
    }

    //wrapper cho byteStream
    public static void CopyFileBuffer1() throws IOException {
        final String inp = "D:\\PIED\\JAVA\\Java Project\\Read-Write_File\\src\\input\\cars.txt";
        final String out = "D:\\PIED\\JAVA\\Java Project\\Read-Write_File\\src\\output\\clonecars.txt";

        BufferedInputStream bufferIn = null;

        BufferedOutputStream bufferOut = null;

        try {

            InputStream i = new FileInputStream(new File(inp)); //truyền vào một object file
            //InputStream i = new FileInputStream(inp); //truyền vào một string
            
            OutputStream o = new FileOutputStream(new File(out));

            bufferIn = new BufferedInputStream(i);

            bufferOut = new BufferedOutputStream(o);

            int c;
            while ((c = bufferIn.read()) != -1) {
                bufferOut.write(c);
            }

        } finally {
            if (bufferIn != null) {
                bufferIn.close();
            }
            if (bufferOut != null) {
                bufferOut.close();
            }
        }
    }

    //wrapper cho characterStream
    public static void CopyFileBuffer2() throws IOException {
        final String inp = "D:\\PIED\\JAVA\\Java Project\\Read-Write_File\\src\\input\\cars.txt";
        final String out = "D:\\PIED\\JAVA\\Java Project\\Read-Write_File\\src\\output\\clonecars_2.txt";

        BufferedReader bufferedReader = null;

        BufferedWriter bufferedWriter = null;

        try {

            Reader reader = new FileReader(inp);
            Writer writer = new FileWriter(out);

            bufferedReader = new BufferedReader(reader);
            bufferedWriter = new BufferedWriter(writer);

            int c;
            while ((c = bufferedReader.read()) != -1) {
                bufferedWriter.write(c);
            }

        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
        }
    }

}
