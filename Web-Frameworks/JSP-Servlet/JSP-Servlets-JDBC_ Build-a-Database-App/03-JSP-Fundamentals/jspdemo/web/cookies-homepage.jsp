<%@page import="javax.servlet.http.Cookie" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

    <%

        //the default if there no cookies
        String favLanguage = "Java";

        //get all cookies from browser quest
        Cookie[] cookiesList = request.getCookies();

        // well, we just find out the cookie we need
        if (cookiesList != null) {
            for (Cookie item : cookiesList) {
                if ("myApp.favoriteLanguage".equals(item.getName())) {
                    favLanguage = item.getValue();
                    break;
                }
            }
        }


    %>
    
    <!-- now we use the customize page base on the favLanguage variable -->
    
    <h1>New books for <%= favLanguage%> </h1>
    <ul>
        <li>first</li>
        <li>second</li>
        <li>third</li>
    </ul>
    
    <h1>Lastest News report for <%= favLanguage%> </h1>
    <ul>
        <li>first</li>
        <li>second</li>
        <li>third</li>
    </ul>
    
    <h1>Hot Job for <%= favLanguage%> </h1>
    <ul>
        <li>first</li>
        <li>second</li>
        <li>third</li>
    </ul>
    
    <hr>
    
    <a href="cookies-personal-site.html">Personalize this page</a>

        
    </body>
</html>
