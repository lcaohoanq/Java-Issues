package com.lcaohoanq.fundamental.libramanagement;

import java.util.Scanner;

public class Book {
    //props
    private String bookName;
    private String createAt;
    private String nickName;
    
    //constructor
    public Book() {
    }

    public Book(String bookName, String createAt, String nickName) {
        this.bookName = bookName;
        this.createAt = createAt;
        this.nickName = nickName;
    }

    public String getBookName() {
        return bookName;
    }

    public String getCreateAt() {
        return createAt;
    }

    public String getNickName() {
        return nickName;
    }

    //input
    public void inputInfor(){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập tên sách");
        this.bookName = input.nextLine();
        
        System.out.println("Nhập ngày tạo");
        this.createAt = input.nextLine();
        
        System.out.println("Nhập nickName(bút danh của tác giả viết sách)");
        this.nickName = input.nextLine();
    }
    
    public void showInfor(){
        System.out.printf("|%-30s|%-15s|%25s|\n", bookName,createAt,nickName);
        
    }
    
}
/*
Book
    bookName createAt nickName

    tạo phễu có đối số và k có đối số
    tạo getter 

    tạo hàm input//nếu mà sách này có tác giả mà 
    có tên trong danh sách tác giả thì bỏ qua
    nếu tác giả của cuốn sách mà chưa có tồn tại trong ds
    thì thêm mới
*/
