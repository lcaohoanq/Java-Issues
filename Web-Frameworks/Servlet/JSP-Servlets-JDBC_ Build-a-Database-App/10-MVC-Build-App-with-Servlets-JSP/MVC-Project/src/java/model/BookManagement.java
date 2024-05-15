package model;

import java.util.ArrayList;
import java.util.List;

public class BookManagement {
    public static List<Book> getAllBooks(){
        
        List<Book> booksList = new ArrayList<>();
        
        booksList.add(new Book(0, "Java for everyone", 1500000));
        booksList.add(new Book(1, "Typescript for Javascript Lover", 500000));
        booksList.add(new Book(2, "Introduction to Software Development", 99000));
        
        return booksList;
    }
}
