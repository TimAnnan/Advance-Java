import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteRow {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://127.0.0.1/college1";
        String username = "root";
        String password = "1234";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            
            String selectQuery = "SELECT * FROM JDBC";
            ResultSet resultSet = statement.executeQuery(selectQuery);

           
            resultSet.first();

            
            resultSet.deleteRow();
            System.out.println("Row deleted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
