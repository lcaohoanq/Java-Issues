package runtime;

import data.Author;
import data.Book;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        //Tạo 2 mảng auList và boList chứa dữ liệu 
        //          tác giả và sách
        ArrayList<Author> auList = new ArrayList<>();
        ArrayList<Book> boList = new ArrayList<>();
        initData(auList, boList);

        Scanner input = new Scanner(System.in);

        int choice;

        do {
            //showMenu
            showMenu();

            //getChoose
            System.out.printf("Nhập lựa chọn của bạn: ");
            choice = Integer.parseInt(input.nextLine());

            //thực thi chức năng
            switch (choice) {
                case 1: {
                    System.out.println("Nhập thông tin sách in ra màn hình");
                    Book newBook = new Book();
                    newBook.inputInfor();//Nhập bookName, createAt, nickname
                    boList.add(newBook); //nhét sách mới vào danh sách

                    //xem thử có tác giả nào có nick name này không
                    //chạy vòng for từ đầu đến cuối
                    //hỏi xem có ai trùng tên với tác giả hay không
                    boolean isFind = false;
                    for (Author author : auList) {
                        if (author.getNickname().equals(newBook.getNickName())) {
                            isFind = true;
                        }
                    }
                    //nếu tác giả đã có rồi => THÔI
                    //nếu chưa có thì phải thêm vào
                    if (!isFind) {
                        //tạo mới tác giả
                        Author newAuthor = new Author(newBook.getNickName());
                        newAuthor.inputInfor();
                        auList.add(newAuthor);
                    }
                    break;
                }
                case 2: {
                    System.out.println("Hiển thị thông tin sách ra màn hình");
                    for (Book book : boList) {
                        book.showInfor();
                    }
                    break;
                }
                case 3: {
                    System.out.println("Nhập thông tin tác giả");
                    Author newAuthor = new Author();
                    newAuthor.inputInfor(auList);
                    //cho nhập nickname, name, yob và có khả năng cấm trùng
                    auList.add(newAuthor);
                    break;
                }
                case 4: {
                    System.out.println("Tìm kiếm sách theo bút danh (nickname)");
                    //scanner đã tạo rồi
                    System.out.println("Bạn muốn tìm sách của ai: ");
                    String findBookOfAuthor = input.nextLine();
                    boolean isFind = false;
                    for (Book book : boList) {
                        if (book.getNickName().equals(findBookOfAuthor)) {
                            book.showInfor();
                            isFind = true;
                        }
                    }
                    if (!isFind) {
                        System.out.println("Không có thông tin sách của tác giả");
                    }
                    break;
                }
                case 5: {
                    System.out.println("Chúc bạn một ngày mới vui vẻ");
                    break;
                }
                default: {
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
                }
            }
            //excuted
        } while (choice != 5);

    }

    public static void showMenu() {
        System.out.println("1.Nhập thông tin sách in ra màn hình");
        System.out.println("2.Hiển thị thông tin sách ra màn hình");
        System.out.println("3.Nhập thông tin tác giả");
        System.out.println("4.Tìm kiếm sách theo bút danh");
        System.out.println("5.Thoát");
    }

    public static void initData(ArrayList<Author> auList,
            ArrayList<Book> boList) {
        auList.add(new Author("Ngô Kiến Huy", "Huy Quan Hoa", 1987));
        auList.add(new Author("Nguyễn Thùy Chi", "Chipu", 1994));
        auList.add(new Author("Lê Mười Điệp", "UncleTen", 1999));

        boList.add(new Book("Mãi mãi là xa lắm", "8-6-2023", "Huy Quan Hoa"));
        boList.add(new Book("Đừng làm mọi thứ phức tạp", "8-6-2023", "Chipu"));
        boList.add(new Book("Em cháy quá, phải dập thôi", "8-6-2023", "UncleTen"));

    }
}
/*
tạo chương trình quản lý thư viện
program:
    menu
    1.Nhập thông tin sách in ra màn hình
    2.Hiển thị thông tin sách ra màn hình
    3.Nhập thông tin tác giả
    4.Tìm kiếm sách theo bút danh
    5.Thoát
*/
