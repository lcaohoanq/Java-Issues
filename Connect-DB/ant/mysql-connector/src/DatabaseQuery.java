import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQuery {
    private DatabaseConnection dbConnection = new DatabaseConnection();
    public List<String> selectUsernameAndScore() {
        List<String> resultList = new ArrayList<>();
        try (Connection connection = dbConnection.getConnection();
            CallableStatement cStatement = connection.prepareCall("{CALL proc_select_username_score()}");
            ResultSet resultSet = cStatement.executeQuery()) {

            while (resultSet.next()) {
                resultList.add(resultSet.getString("username") + " " + resultSet.getInt("score"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultList;
    }


}
