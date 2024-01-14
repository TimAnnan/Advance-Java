import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Delete {
    public static void main(String[] args) {
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/college1?autoReconnect=true&useSSL=false","root","1234");
   Statement stmt = conn.createStatement();
) {
    System.out.println("Delete values from the table");
    String sql = "delete from JDBC where usn='1CR22MC088' ";
    stmt.executeUpdate(sql);
    System.out.println("deleted values from the table");

}
catch(SQLException e) {
    e.printStackTrace();
}
    }
    
}
