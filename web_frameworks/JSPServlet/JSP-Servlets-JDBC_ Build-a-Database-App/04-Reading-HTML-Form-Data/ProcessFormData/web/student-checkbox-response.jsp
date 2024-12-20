
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Confirmation Page</title>
    </head>
    <body>
        <h1>The student is confirm: ${param.firstName} ${param.lastName} </h1>
        <h1>The student is favorite programming language: ${param.favoriteLanguage}</h1>
        <%
                String foodList[] = request.getParameterValues("favoriteFood");
        %>
        <h1>The student is favorite food: </br>
            <%
                
                for(String food: foodList){
                    out.println(food + "</br>");
                }

            %>
        </h1>
        
        <!-- Other way -->
        <ul>The student is favorite food: </br>
            
            <%
                String foodList2[] = request.getParameterValues("favoriteFood");
                
                for(String food: foodList2){
                    out.println("<li>" + food + "</li>");
                }

            %>
        </ul>
        
    </body>
</html>
