import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public Connection getConnection() throws SQLException{
        try{
            String db_url = EnvUtils.get("DB_URL");
            String db_user = EnvUtils.get("DB_USER");
            String db_password = EnvUtils.get("DB_PASSWORD");
            return DriverManager.getConnection(db_url, db_user, db_password);
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}