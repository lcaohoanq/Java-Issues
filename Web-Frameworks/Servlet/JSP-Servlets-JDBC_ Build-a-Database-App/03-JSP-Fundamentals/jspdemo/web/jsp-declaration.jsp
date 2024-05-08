<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.Person"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%!
            int makeYounger(int age){
                return age - 5;
            }
        %>
        
        
        
        <%!
            Person admin = new Person("lcaohoanq", makeYounger(20));
        %>
        
        <h1>Hello <%= admin.toString() %> </h1>
        
        
    </body>
</html>
