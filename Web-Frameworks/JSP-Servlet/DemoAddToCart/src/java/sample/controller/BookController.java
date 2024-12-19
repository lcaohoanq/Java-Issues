package sample.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.product.CartDTO;
import sample.book.BookDAO;
import sample.book.BookDTO;
import sample.product.CartBookDTO;

public class BookController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("booksList", new BookDAO().getAllBooks());
        request.getRequestDispatcher("./book.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = request.getParameter("command");
        if ("ADD_TO_CART".equals(command)) {
            String bookID = request.getParameter("bookID");
            HttpSession session = request.getSession();
            CartBookDTO cart = (CartBookDTO) session.getAttribute("cart");
            if (cart == null) {
                cart = new CartBookDTO();
            }
            BookDAO bookDAO = new BookDAO();
            BookDTO book = bookDAO.getBookByID(bookID);
            cart.add(book);
            session.setAttribute("cart", cart);
        }
        response.sendRedirect("BookController");
    }
}
