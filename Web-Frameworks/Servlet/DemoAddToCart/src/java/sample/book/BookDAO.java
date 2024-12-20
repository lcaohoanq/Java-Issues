package sample.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBUtils;

public class BookDAO {

    private static final String SELECT_ALL_BOOKS = "SELECT * FROM tblBooks";

    public List<BookDTO> getAllBooks() {
        List<BookDTO> booksList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtils.getConnection();
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS);
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    String bookID = resultSet.getString("SKU");
                    String bookName = resultSet.getString("Name");
                    double bookPrice = resultSet.getDouble("Price");
                    String bookDescription = resultSet.getString("Description");
                    int bookQuantity = resultSet.getInt("Quantity");

                    booksList.add(new BookDTO(bookID, bookName, bookPrice, bookDescription, bookQuantity));
                }
            } else {
                throw new SQLException("Connection fail");
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return booksList;

    }

    public static void main(String[] args) {

        List<BookDTO> booksList = new BookDAO().getAllBooks();
        booksList.stream().forEach(System.out::println);

    }
    
//     public List<BookDTO> getAllBooks() {
//        // Mock data for demonstration
//        List<BookDTO> books = new ArrayList<>();
//        books.add(new BookDTO("1", "Book One", 10.0, "Description One", 5));
//        books.add(new BookDTO("2", "Book Two", 15.0, "Description Two", 3));
//        // Add more books as needed
//        return books;
//    }
//
//    public BookDTO getBookByID(String bookID) {
//        // Implement fetching book by ID logic
//        // For demonstration, returning a mock book
//        return new BookDTO(bookID, "Sample Book", 20.0, "Sample Description", 1);
//    }
//    
//    public static void main(String[] args) {
//        new BookDAO().getAllBooks().stream().forEach(System.out::println);
//    }

}
