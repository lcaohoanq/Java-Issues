<%@page import="javax.servlet.http.Cookie" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Persional Response</title>
    </head>
        <%

            String favLanguage = request.getParameter("favoriteLanguage");

            Cookie cookie = new Cookie("myApp.favoriteLanguage", favLanguage);
            cookie.setMaxAge(60*5);
            
            response.addCookie(cookie);

        %>
    <body>
        
        <h1>Thanks, we've set the page to ${param.favoriteLanguage}</h1>
        
        <a href="cookies-homepage.jsp">Return to home page</a>
        
    </body>
</html>
