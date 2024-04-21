package crm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet (name="helloServlet", urlPatterns="/hello")
public class HelloServlet extends HttpServlet{

    //http:localhost://hello?username=admin&password=admin
    
    @Override
    public void init() throws ServletException {
        System.out.println("Hello Init Servlet");
    }

    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.getWriter().append("Hello");
        req.getRequestDispatcher("/hello.jsp").forward(req, resp);
        
        String username = req.getParameter("username");        
        String password = req.getParameter("password");
        
        Account account = new Account(username, password);
        
        if(account.isAdmin()){
            System.out.println("Is Admin");
        }else{
            System.out.println("Not an admin");
        }
        
        
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello doPost");
    }
    
}
