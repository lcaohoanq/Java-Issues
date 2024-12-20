package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import utils.DBUtils;

public class AppointmentDAO {

    public void addAppointment(int userId, String appointmentDate, String appointmentTime, String purpose) {
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(
                        "INSERT INTO Appointments (userId, appointmentDate, appointmentTime, purpose, status) VALUES (?, ?, ?, ?, ?)");
                ptm.setInt(1, userId);
                ptm.setString(2, appointmentDate);
                ptm.setString(3, appointmentTime);
                ptm.setString(4, purpose);
                ptm.setString(5, "Scheduled");
                ptm.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAppointment(int id) {
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(
                        "DELETE FROM Appointments WHERE id = ?");
                ptm.setInt(1, id);
                ptm.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editAppointment(int id, String appointmentDate, String appointmentTime, String purpose) {
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(
                        "UPDATE Appointments SET appointmentDate = ?, appointmentTime = ?, purpose = ? WHERE id = ?");
                ptm.setString(1, appointmentDate);
                ptm.setString(2, appointmentTime);
                ptm.setString(3, purpose);
                ptm.setInt(4, id);
                ptm.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cancelAppointment(int id) {
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(
                        "UPDATE Appointments SET status = 'Cancelled' WHERE id = ?");
                ptm.setInt(1, id);
                ptm.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openAppointment(int id) {
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(
                        "UPDATE Appointments SET status = 'Scheduled' WHERE id = ?");
                ptm.setInt(1, id);
                ptm.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void completedAppointment(int id) {
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(
                        "UPDATE Appointments SET status = 'Completed' WHERE id = ?");
                ptm.setInt(1, id);
                ptm.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Date getDateAppointment(int id) {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT appointmentDate FROM Appointments WHERE id = ?");
                ptm.setInt(1, id);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    return rs.getDate("appointmentDate");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Time getTimeAppointment(int id) {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT appointmentTime FROM Appointments WHERE id = ?");
                ptm.setInt(1, id);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    return rs.getTime("appointmentTime");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getPurpose(int id) {
        String purpose = "";
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT purpose FROM Appointments WHERE id = ?");
                ptm.setInt(1, id);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    purpose = rs.getString("purpose");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return purpose;
    }

    public String getAppointmentStatus(int id) {
        String status = "";
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT status FROM Appointments WHERE id = ?");
                ptm.setInt(1, id);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    status = rs.getString("status");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static void main(String[] args) {
        System.out.println(new AppointmentDAO().getTimeAppointment(1).toString());
    }

}
