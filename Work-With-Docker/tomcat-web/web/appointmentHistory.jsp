<%@page import="utils.DBUtils"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History</title>
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
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Appointments WHERE userId = ? AND status = 'Completed'");
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
        %>
        <h1 class="text-center mt-5 mb-5">Appointment History</h1>
        <%
            if (!rs.isBeforeFirst()) { // Check if the result set is empty
        %>
        <p class="text-center">No completed appointments found.</p>
        <%
        } else {
        %>
        <table class="table" border="1">
            <tr>
                <th scope="col">Date</th>
                <th scope="col">Time</th>
                <th scope="col">Purpose</th>
                <th scope="col">Status</th>
            </tr>
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
            %>
        </table>
        <%
            }
            stmt.close();
            conn.close();
        %>

        <div class="d-flex justify-content-center align-items-center mt-5">
            <a class="btn btn-primary" href="dashboard.jsp">Back to Dashboard</a>
        </div>

        <!-- Bootstrap JS -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
    </body>
</html>
