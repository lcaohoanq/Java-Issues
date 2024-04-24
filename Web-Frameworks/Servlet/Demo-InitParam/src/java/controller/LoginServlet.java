package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.getRequestDispatcher("./login.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        String u = getServletContext().getInitParameter("username"); //admin
        String p = getServletContext().getInitParameter("password"); //admin

        if (!isAdmin(username, password)) {
//            req.getRequestDispatcher("./login.jsp").forward(req, res);
            res.sendRedirect(req.getContextPath() + "/login");
        } else {
            req.getRequestDispatcher("./demo.jsp").forward(req, res);
        }
    }

    boolean isAdmin(String username, String password) {
        return username.equals("admin") && password.equals("admin");
    }

}
