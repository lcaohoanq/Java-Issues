/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lcaohoanq
 */
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //1. set content type
        response.setContentType("text/html");
        
        //2. get the printwriter
        PrintWriter out = response.getWriter();
        
        //3. generate the HTML
        out.print("<html><body>");
        out.println("The student is confirmed: " 
                        + request.getParameter("firstName") + " "
                        + request.getParameter("lastName"));
        out.print("</body></html>");
        
        System.out.println(request.getParameter("firstName") + " " +  request.getParameter("lastName"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
