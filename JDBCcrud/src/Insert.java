import java.io.BufferedReader;
import java.io.*;
import java.sql.*;


public class Insert {
    public static void main(String[] args) {
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/college1?autoReconnect=true&useSSL=false","root","1234");
   Statement stmt = conn.createStatement();
) {
    //execute a query
    System.out.println("Inserting records to the table..");
    String sql = "INSERT INTO JDBC VALUES('1CR22MC088','Shubam','Yadav','MCA')";
    stmt.executeUpdate(sql);
    System.out.println("Inserted vaues to the table..");
}
catch (SQLException e) {
    e.printStackTrace();
}
    }
    
}
