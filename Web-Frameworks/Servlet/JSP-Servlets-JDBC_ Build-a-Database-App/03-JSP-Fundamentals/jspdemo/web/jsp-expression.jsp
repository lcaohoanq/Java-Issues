<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.Person"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World! <%= new java.util.Date()%></h1>

        <h1>My name is: <%= "Hoang"%></h1>

        <%
            // Handling exception when calling getName()
            String personName = "";
            try {
                personName = new Person("hoang", 12).getName();
            } catch (Exception e) {
                // Handle the exception here
                e.printStackTrace(); // For debugging, you can print the stack trace
            }
        %>
        <h1>I'm: <%= personName%></h1>

        <h1>1 + 2 = <%= 1 + 2%></h1>

        <h1>Am i handsome: <%=  45 < 67%> </h1>

    </body>
</html>
