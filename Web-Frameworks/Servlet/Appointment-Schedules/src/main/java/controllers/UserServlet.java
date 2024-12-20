package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.UserDTO;
import org.mindrot.jbcrypt.BCrypt;
import service.UserService;

@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("./login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println("Du lieu nhan trong UserServlet: " + action);
        switch (action) {
            case "viewLogin":
                request.getRequestDispatcher("./login.jsp").forward(request, response);
                break;
            case "viewRegister":
                request.getRequestDispatcher("./register.jsp").forward(request, response);
                break;
            case "submitRegister":
                registerUser(request, response);
                break;
            case "submitLogin":
                loginUser(request, response);
                break;
            case "submitLogout":
                logoutUser(request, response);
                break;
            default:
                request.getRequestDispatcher("./404.jsp").forward(request, response);
                break;
        }
    }

    private void registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        try {
            request.setAttribute("registerStatus", (new UserService().registerUser(new UserDTO(username, hashedPassword, email)) == 1 ? "ok" : "fail"));
            request.getRequestDispatcher("./register.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }

    private void loginUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            UserService UserService = new UserService();

            if (password.isEmpty() || username.isEmpty()) {
                String storedPassword = UserService.findUserByUsername(username).getPassword();
                if (BCrypt.checkpw(password, storedPassword)) {
                    HttpSession session = request.getSession();
                    session.setAttribute("userId", UserService.findUserByUsername(username).getId());
                    session.setAttribute("username", username);
                    response.sendRedirect("dashboard.jsp");
                } else {
                    response.sendRedirect("login.jsp?error=invalid");
                }
            } else {
                response.sendRedirect("login.jsp?error=invalid");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void logoutUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("login.jsp");
    }

}
