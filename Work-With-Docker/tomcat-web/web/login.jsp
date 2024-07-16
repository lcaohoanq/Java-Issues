<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <style>
            body{
                display: flex;
                align-items: center;
                justify-content: center;
                min-height: 100vh;
                background-color: #f1f1f1;
            }
        </style>
    </head>
    <body>
        <form action="MainController" method="POST">
            <div class="mb-3">
                <label for="inp-username" class="form-label">Username</label>
                <input type="text" class="form-control" id="inp-username" name="username"><br>
                <div id="emailHelp" class="form-text">We'll never share your data with anyone else.</div>
            </div>
            <div class="mb-3">
                <label for="inp-password" class="form-label">Password</label>
                <input type="password" class="form-control" id="inp-password" name="password"><br>
            </div>

            <div class="d-flex flex-row justify-content-center align-items-center">
                <button class="btn btn-primary me-3" type="submit" name="action" value="submitLogin">Login</button>
                <button class="btn btn-success" type="submit" name="action" value="viewRegister">Register</button>
            </div>
        </form>
        <%
            String error = request.getParameter("error");
            if ("invalid".equals(error)) {
        %>
        <p style="color:red">Invalid username or password</p>
        <%
            }
        %>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
    </body>
</html>
