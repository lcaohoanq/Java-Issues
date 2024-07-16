package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.UserDTO;
import utils.DBUtils;

public class UserDAO {

    public boolean checkLogin(String username) throws SQLException,ClassNotFoundException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT * FROM Users WHERE username = ?");
                ptm.setString(1, username);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }

    public int registerUser(String username, String password, String email) throws SQLException,ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ptm = null;
        int rowsAffected = 0;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("INSERT INTO Users (username, password, email) VALUES (?, ?, ?)");
                ptm.setString(1, username);
                ptm.setString(2, password);
                ptm.setString(3, email);
                rowsAffected = ptm.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rowsAffected;
    }

    public String getPassword(String username) throws SQLException ,ClassNotFoundException{
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT password FROM Users WHERE username = ?");
                ptm.setString(1, username);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    return rs.getString("password");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return null;
    }

    public String getUserName(int id) throws SQLException,ClassNotFoundException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT username FROM Users WHERE id = ?");
                ptm.setInt(1, id);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    return rs.getString("username");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return null;
    }

    public String getEmail(int id) throws SQLException, ClassNotFoundException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT email FROM Users WHERE id = ?");
                ptm.setInt(1, id);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    return rs.getString("email");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return null;
    }

    public int getID(String username) throws SQLException,ClassNotFoundException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT id FROM Users WHERE username = ?");
                ptm.setString(1, username);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    return rs.getInt("id");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    public static void main(String[] args) {
        try {
            System.out.println(new UserDAO().registerUser("test2", "1", "caohoanggt0@gmail.com"));
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
