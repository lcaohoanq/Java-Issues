import com.lcaohoanq.jdbc.maven.mysql.DatabaseQuery;

public class Main {
    public static void main(String[] args) {
        DatabaseQuery dbQuery = new DatabaseQuery();
        dbQuery.selectUsernameAndScore().forEach(System.out::println);
    }
}
