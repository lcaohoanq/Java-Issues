<%-- 
    Document   : built-in
    Created on : May 8, 2024, 10:17:52 AM
    Author     : lcaohoanq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Request user agent: <%= request.getHeader("User-Agent")%> </br>
        Request language: <%= request.getLocale()%>
    </body>
</html>
