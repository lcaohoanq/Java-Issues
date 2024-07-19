package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import models.AppointmentDTO;
import service.AppointmentService;
import service.UserService;
import utils.DBUtils;
import utils.EmailUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lcaohoanq
 */
@WebServlet(name = "AppointmentServlet", urlPatterns = {"/AppointmentServlet"})
public class AppointmentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        System.out.println("Du lieu da nhan trong Appointment: " + action);

        switch (action) {
            case "viewAll":
                request.getRequestDispatcher("./viewAppointment.jsp").forward(request, response);
                break;
            case "viewHistory":
                request.getRequestDispatcher("./appointmentHistory.jsp").forward(request, response);
                break;
            case "viewDashboard":
                request.getRequestDispatcher("./dashboard.jsp").forward(request, response);
                break;
            case "createNewPrompt":
                request.getRequestDispatcher("./createAppointment.jsp").forward(request, response);
                break;
            case "createNew":
                createAppointment(request, response);
                break;
            case "showEditAppointment":
                request.getRequestDispatcher("./editAppointment.jsp").forward(request, response);
                break;
            case "saveChangeEditAppointment":
                editAppointment(request, response);
                break;
            case "deleteAppointment":
                deleteAppointment(request, response);
                break;
            case "cancelAppointment":
                cancelAppointment(request, response);
                break;
            case "openAppointment":
                openAppointment(request, response);
                break;
            case "completedAppointment":
                completedAppointment(request, response);
                break;
            case "unCompletedAppointment":
                // uncompleted ~ back to scheduled status
                openAppointment(request, response);
                break;
            case "sendReminder":
                sendReminders(request, response);
                break;
            default:
                request.getRequestDispatcher("./404.jsp").forward(request, response);
                break;
        }
    }

    private void createAppointment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("userId");
        String appointmentDateStr = request.getParameter("appointmentDate");
        String appointmentTimeStr = request.getParameter("appointmentTime");
        String purpose = request.getParameter("purpose");

        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");

        try {

            Timestamp appointmentDate = new Timestamp(dateFormatter.parse(appointmentDateStr).getTime());
            Date appointmentTime = timeFormatter.parse(appointmentTimeStr);

            new AppointmentService().addAppointment(new AppointmentDTO(userId, appointmentDate, appointmentTime, purpose));
            response.sendRedirect("dashboard.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void editAppointment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String appointmentDateStr = request.getParameter("appointmentDate");
        String appointmentTimeStr = request.getParameter("appointmentTime");
        String purpose = request.getParameter("purpose");

        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");

        try {

            Timestamp appointmentDate = new Timestamp(dateFormatter.parse(appointmentDateStr).getTime());
            Date appointmentTime = timeFormatter.parse(appointmentTimeStr);
            new AppointmentService().editAppointment(new AppointmentDTO(id, appointmentDate, appointmentTime, purpose));
            response.sendRedirect("viewAppointment.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openAppointment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            new AppointmentService().openAppointment(id);
            response.sendRedirect("viewAppointment.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteAppointment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            new AppointmentService().deleteAppointment(id);
            response.sendRedirect("viewAppointment.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cancelAppointment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("In cancel appointment");
        try {
            new AppointmentService().cancelAppointment(id);
            response.sendRedirect("viewAppointment.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void completedAppointment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            new AppointmentService().completedAppointment(id);
            response.sendRedirect("viewAppointment.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendReminders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String userIdStr = request.getParameter("userId");

        try {
            if (idStr != null && userIdStr != null) {
                int id = Integer.parseInt(idStr);
                int userId = Integer.parseInt(userIdStr);

                Connection conn = DBUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT appointmentDate, appointmentTime FROM Appointments WHERE id = ?");
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    Date appointmentDate = rs.getDate("appointmentDate");
                    Time appointmentTime = rs.getTime("appointmentTime");

                    Timestamp appointmentTimestamp = new Timestamp(appointmentDate.getTime() + appointmentTime.getTime());
                    Timestamp currentTime = new Timestamp(System.currentTimeMillis());

                    if (appointmentTimestamp.before(currentTime)) {
                        response.setContentType("text/html");
                        PrintWriter out = response.getWriter();
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert('The appointment time is in the past. No email will be sent.');");
                        out.println("window.location.href = 'viewAppointment.jsp';");
                        out.println("</script>");
                    } else {
                        EmailUtils handleEmail = new EmailUtils();
                        UserService userService = new UserService();
                        AppointmentService apService = new AppointmentService();
                        String email = userService.findUserById(userId).getEmail();

                        String sub = "Reminder Notification";
                        String msg = handleEmail.messageNewOrder(userService.findUserById(userId).getUsername(), apService.findAppointmentById(id).getAppointmentDate().toString(), apService.findAppointmentById(id).getAppointmentTime().toString(), apService.findAppointmentById(id).getPurpose());
                        handleEmail.sendEmail(sub, msg, email);
                    }
                }

                rs.close();
                stmt.close();
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            request.getRequestDispatcher("./viewAppointment.jsp").forward(request, response);
        }
    }

}
