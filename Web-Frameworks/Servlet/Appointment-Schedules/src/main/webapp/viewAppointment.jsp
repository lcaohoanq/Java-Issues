<%@page import="utils.DBUtils"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View</title>
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
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Appointments WHERE userId = ?");
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
        %>
        <h1 class="text-center mt-5 mb-5">All Appointments</h1>

        <table class="table" border="1">
            <thead>
                <tr>
                    <th scope="col">Date</th>
                    <th scope="col">Time</th>
                    <th scope="col">Purpose</th>
                    <th scope="col">Status</th>
                    <th scope="col">Actions</th>
                </tr>
            </thead>
            <tbody>

                <%
                    while (rs.next()) {
                        String status = rs.getString("status");
                %>
                <tr>
                    <td><%= rs.getDate("appointmentDate")%></td>
                    <td><%= rs.getTime("appointmentTime")%></td>
                    <td><%= rs.getString("purpose")%></td>
                    <td><%= status%></td>
                    <td>
                        <form action="MainController" method="POST">    
                            <!--<a class="btn btn-warning" href="editAppointment.jsp?id=<%= rs.getInt("id")%>">Edit</a>-->
                            <button class="btn btn-warning" name="action" value="showEditAppointment">Edit</button>
                            <button class="btn btn-danger" name="action" value="deleteAppointment">Delete</button>
                            <!-- this is id of appointment -->
                            <input type="hidden" name="id" value="<%= rs.getInt("id")%>">

                            <input type="hidden" name="userId" value="<%= userId%>">

                            <%
                                if ("Cancelled".equals(status)) {
                            %>
                            <button class="btn btn-success" name="action" value="openAppointment">Open</button>
                            <button class="btn btn-success" name="action" value="completedAppointment">Completed</button>

                            <%
                            } else if ("Completed".equals(status)) {
                            %>
                            <button class="d-none" name="action" value="completedAppointment">Completed</button>
                            <button class="btn btn-primary" name="action" value="unCompletedAppointment">Un-Completed</button>
                            <%
                            } else if ("Scheduled".equals(status)) {
                            %>
                            <button class="btn btn-danger" name="action" value="cancelAppointment">Cancel</button>
                            <button class="btn btn-success" name="action" value="completedAppointment">Completed</button>
                            <%
                                }
                            %>
                            <button class="btn btn-success" name="action" value="sendReminder">Reminder</button>
                        </form>
                    </td>
                </tr>
                <%
                    }
                    stmt.close();
                    conn.close();
                %>
            </tbody>
        </table>

        <div class="d-flex justify-content-center align-items-center mt-5">
            <a class="btn btn-primary" href="dashboard.jsp">Back to Dashboard</a>
        </div>
        <!-- Bootstrap JS -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
    </body>
</html>
