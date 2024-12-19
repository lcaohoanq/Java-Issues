package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author lcaohoanq
 */
@WebServlet(name = "AreaServlet", urlPatterns = {"/area"})
public class AreaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/sum.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String length = request.getParameter("length");
        String width = request.getParameter("width");
        
        double result = Double.parseDouble(width) *  Double.parseDouble(length);
        
        PrintWriter out = response.getWriter();
        
        out.print(calArea(Double.parseDouble(width), Double.parseDouble(length)));
    }
    
    double calArea(double length, double width){
       return length * width; 
    }
}
