<%@ page import="javax.servlet.http.HttpSession" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="./style.css"/>
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
        <%
            if (session == null || session.getAttribute("username") == null) {
                response.sendRedirect("login.jsp");
            }
        %>

        <form action="MainController" method="POST">
            <div class="mb-3">
                <label for="inpDate" class="form-label">Date</label>
                <input class="form-control" id="inpDate" type="date" name="appointmentDate" required><br>
            </div>
            <div class="mb-3">
                <label for="inpTime" class="form-label">Date</label>
                <input class="form-control" id="inpTime" type="time" name="appointmentTime" required><br>
            </div>
            <div class="mb-3">
                <label for="inpPurpose" class="form-label">Date</label>
                <input class="form-control" id="inpPurpose" type="text" name="purpose" required><br>
            </div>
            <button class="btn btn-primary" type="submit" name="action" value="createNew">Create Appointment</button>
            <a class="btn btn-danger" href="dashboard.jsp">Back to Dashboard</a>
        </form>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
    </body>
</html>
