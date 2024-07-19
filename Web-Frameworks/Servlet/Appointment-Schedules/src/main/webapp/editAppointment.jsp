<%@page import="utils.DBUtils"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <style>
            body{
                display: flex;
                align-items: center;
                justify-content: center;
                min-height: 100vh;
                background-color: #f1f1f1;
            </style>
            }
        </style>
    </head>
    <body>
        <%
            if (session == null || session.getAttribute("username") == null) {
                response.sendRedirect("login.jsp");
            }

            int id = Integer.parseInt(request.getParameter("id"));
            Connection conn = DBUtils.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Appointments WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
        %>
        <form action="MainController" method="POST">
            <input type="hidden" name="id" value="<%= id%>">

            <div class="mb-3">
                <label for="changeDate" class="form-label">Date</label>
                <input class="form-control" id="changeDate" type="date" name="appointmentDate" value="<%= rs.getDate("appointmentDate")%>" required><br>
            </div>
            <div class="mb-3">
                <label for="changeTime" class="form-label">Time</label>
                <input class="form-control" id="changeTime" type="time" name="appointmentTime" value="<%= rs.getTime("appointmentTime")%>" required><br>
            </div>
            <div class="mb-3">
                <label for="changePurpose" class="form-label">Purpose</label>
                <input class="form-control" id="changePurpose" type="text" name="purpose" value="<%= rs.getString("purpose")%>" required><br>
            </div>

            <button class="btn btn-primary" type="submit" name="action" value="saveChangeEditAppointment">Save Changes</button>
            <a class="btn btn-danger" href="viewAppointment.jsp">Back to Appointments</a>
        </form>
        <%
            }
            stmt.close();
            conn.close();
        %>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
    </body>
</html>
