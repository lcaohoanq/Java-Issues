package com.lcaohoanq.fundamental.libramanagement;

import java.util.ArrayList;
import java.util.Scanner;

public class Author {
    //props
    private String name;
    private String nickname;
    private int yob;
    
    //Phễu có đầy đủ đối số
    public Author(String name, String nickname, int yob) {
        this.name = name;
        this.nickname = nickname;
        this.yob = yob;
    }
    //phễu không có đối số
    public Author(){
    }
    
    //phễu có đối số là nickname
    public Author(String nickname) {
        this.nickname = nickname;
    }
    
    //getter
    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public int getYob() {
        return yob;
    }
    
    //tạo hàm nhập thông tin
    public void inputInfor(){ //nhập name, yob
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập tên của tác giả: ");
        this.name = input.nextLine();
        
        System.out.println("Nhập năm sinh của tác giả: ");
        this.yob = Integer.parseInt(input.nextLine());
    }
    
    //overload: quá tải hàm,
    //          hàm cùng tên nhưng khác đầu vào
    
    //lưu các tác giả vào mảng để xét có trùng hay không
    //ngoài ra còn xài được nhập name và yob
    public void inputInfor(ArrayList<Author> authorList){ 
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập nickname cho tác giả: ");
        //vòng lặp vô tận
        while(true){
            String inpNickname = input.nextLine();
            //tìm xem inpNickname đã có tsac giả nào sử dụng chưa
            boolean isDup = false;
            for (Author author : authorList) {
                //equals() trả ra true hoặc false                
                if(author.getNickname().equals(inpNickname)){
                    isDup = true;
                }
            }
            if(isDup){
                System.out.println("Nickname có người dùng rồi!!!");
            }else {
                this.nickname = inpNickname;
                this.inputInfor(); //nhập name, yob
                break;
            }
        }
    }
    
    public void showInfor(){
        String str = String.format("|%-25s|%-25f|%4d|\n", name,nickname,yob);
        System.out.print(str);
    }
    
}
/*
Author
    name nickname yob;

    tạo phễu hàm không đối số
    tạo phễu có đối số 
    tạo phễu có đối số là nickname

    tạo getter không tạo setter

    tạo hàm nhập thông tin tác giả (tên và năm sinh)
    nếu nick name tác giả đã tồn tại trong danh sách thì k cho + ép nhập lại

    tạo hàm showInfor
*/