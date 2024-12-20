package ui;

import data.Brand;
import java.util.ArrayList;
import tool.ConsoleColors;
import tool.Inputter;

/*
Menu: là 1 khuôn chuyên đúc ra object quản lý menu
cái khuôn này chứa 1 danh sách các lựa chọn (opt)
method addNewOption : thêm 1 Option
method print        : in ra danh sách các menu
method getChoice    : lấy lựa chọn từ người dùng
*/
public class Menu {
    ArrayList<String> optionList = new ArrayList<>();
    public String title;
    
    //constructor
    public Menu(String title) {
        this.title = title;
    }
    
    //3 method
    //addNewOption
    public void addNewOption(String nOptional){
        optionList.add(nOptional);
    }
    
    //print
    public void print(){
        int count = 1;
        System.out.println(ConsoleColors.YELLOW + "---------------------"+title+"--------------------" + ConsoleColors.RESET );
        for (String item : optionList) {
            System.out.println(count + ". "+ item);
            count++;
        }
    }
    
    //getChoice
    public int getChoice(){
        int choice = Inputter.getAnInteger("Input your choice: ", "Required between 1 and" + optionList.size(), 1, optionList.size());
        return choice;
    }
    
    //hàm nhận vào một danh sách Brand
    //in ra danh sách, kèm số thứ tự 
    //ví dụ: 1 B7-2018, BMW 730Li (2018), Harman Kardon: 3.749
    //cho người dùng chọn hãng độ xe mà họ thích 
    //bằng stt
    //return ra đúng hãng độ xe họ đã chọn
    public Brand ref_getChoice(ArrayList<Brand> brandList){
        int count = 1;
        for (Brand item : brandList) {
            //đánh số thứ tự cho từng dòng 
            System.out.println(count + " " + item.toString());
            count++;
        }
        
        int choice = Inputter.getAnInteger("Input SEQ of Brand: ", "SEQ must be between 1 and " + brandList.size(), 1, brandList.size());
        //nếu return choice thì sẽ bị trật một nhịp vì khai báo count lúc đầu = 1 
        //mảng sẽ đếm từ 0
        return brandList.get(choice - 1);
    }
    
}

