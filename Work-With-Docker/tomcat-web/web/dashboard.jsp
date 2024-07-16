<%@page import="utils.DBUtils"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <style>
            body{
                background-color: #f1f1f1;
            }
        </style>    
    </head>
    <body>

        <%
            if (session == null || session.getAttribute("username") == null) {
                response.sendRedirect("login.jsp");
            }

            int userId = (int) session.getAttribute("userId");
            Connection conn = DBUtils.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Appointments WHERE userId = ? AND status = 'Scheduled'");
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
        %>

        <!-- Header -->
        <form method="POST" action="MainController" class="d-flex justify-content-center align-items-center mb-3">
            <h1 class="text-center mt-3 mb-3 me-5">Welcome, <%= session.getAttribute("username")%></h1>
            <button class="btn btn-danger mt-3 mb-3 col-md-3"  name="action" value="submitLogout">Logout</button>
        </form>

        <h3 class="text-center mb-5">Upcoming Appointments</h3>
        <table class="table" border="1">
            <thead>
                <tr>
                    <th scope="col">Date</th>
                    <th scope="col">Time</th>
                    <th scope="col">Purpose</th>
                    <th scope="col">Status</th>
                </tr>
            </thead>
            <tbody>
                <%
                    while (rs.next()) {
                %>
                <tr>
                    <td><%= rs.getDate("appointmentDate")%></td>
                    <td><%= rs.getTime("appointmentTime")%></td>
                    <td><%= rs.getString("purpose")%></td>
                    <td><%= rs.getString("status")%></td>
                </tr>
                <%
                    }
                    stmt.close();
                    conn.close();
                %>
            </tbody>
        </table>

        <form method="POST" action="MainController">
            <div class="row d-flex justify-content-center">
                <button class="col-md-3 btn btn-primary mt-3 me-3" name="action" value="createNewPrompt">Create New Appointment</button>
                <button class="col-md-3 btn btn-primary mt-3 me-3" name="action" value="viewAll">View All Appointments</button>
                <button class="col-md-3 btn btn-primary mt-3 me-3"  name="action" value="viewHistory">View All History</button>
            </div>
        </form>

        <!-- Bootstrap JS -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>

    </body>
</html>
