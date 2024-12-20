<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login page</title>
        <link rel="stylesheet" href="./reset.css"/>
        <link rel="stylesheet" href="./login.css"/>
    </head>
    <body>
        <div class="container"> 
            <div class="title"> 
                <h1>Login</h1>
            </div>
            <form action="http://localhost:9999/init-param/login" method="post">
                <label for="username">Username</label>
                <input type="text" name="username" id = "username">
                <label for="password">Password</label>
                <input type="password" name="password" id = "password">
                <button>Submit</button>
            </form>
        </div>
    </body>
</html>
