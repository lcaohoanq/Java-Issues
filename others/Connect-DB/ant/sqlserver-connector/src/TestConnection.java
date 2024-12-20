import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {

    public static void main(String[] args) {

        String sql = "SELECT * FROM Users";

        Dotenv dotenv = Dotenv.configure().load();

        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser(dotenv.get("DB_USER"));
        ds.setPassword(dotenv.get("DB_PASSWORD"));
        ds.setServerName(dotenv.get("DB_HOST"));
        ds.setPortNumber(Integer.parseInt(dotenv.get("DB_PORT")));
        ds.setDatabaseName(dotenv.get("DB_TABLE"));

        try(Connection conn = ds.getConnection()){
            System.out.println("Connection successful!");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String username = rs.getString("username");
                System.out.println("Username: " + username);
            }
            System.out.println(conn.getMetaData());
        } catch (SQLServerException e){
            e.printStackTrace();
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    public static String get(String key){
        return System.getenv(key);
    }
}