<%-- 
    Document   : login
    Created on : Apr 21, 2024, 9:49:52 PM
    Author     : lcaohoanq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form action="http://localhost:8080/login" method="post">
            <input type="text" name="username" placeholder="Username">
            <input type="text" name="password" placeholder="Password">
            <button>Login</button>
        </form>
    </body>
</html>
