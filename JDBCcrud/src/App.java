import java.io.BufferedReader;
import java.io.*;
import java.sql.*;

public class App {

    public static void main(String[] args) {

// Open a connection
try(Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/college1?autoReconnect=true&useSSL=false","root","1234");
   Statement stmt = conn.createStatement();
) {              
    String sql = "CREATE TABLE REGISTRATION1 " +
             "(id INTEGER not NULL, " +
             " first VARCHAR(255), " +
             " last VARCHAR(255), " +
             " age INTEGER, " +
             " PRIMARY KEY ( id ))";

   stmt.executeUpdate(sql);
   System.out.println("Created table in given database...");        
} catch (SQLException e) {
   e.printStackTrace();
}
}
}