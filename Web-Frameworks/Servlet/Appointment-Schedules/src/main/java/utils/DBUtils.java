package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

    public static final Connection getConnection() throws ClassNotFoundException, SQLException {
    Connection conn = null;
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=appointment_schedules", "sa", "Luucaohoang1604^^");
    return conn;
  }

  public static void main(String[] args) throws Exception {
    try (Connection con = DBUtils.getConnection()) {
      System.out.println("Connected successfully");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
