import java.io.*;
import java.sql.*;

public class Update {
    public static void main(String[] args) {
        String dburl = "jdbc:mysql://127.0.0.1/college1?autoReconnect=true&useSSL=false";
        String dbuser = "root";
        String dbpass = "1234";
        Connection conn = null;
        Savepoint s1 = null;
        Statement stmt1,stmt2 = null;
        try {
            conn = DriverManager.getConnection(dburl, dbuser, dbpass);
            conn.setAutoCommit(false);
            String insert = "INSERT INTO JDBC VALUES('1CR22MC090','YATI','SHUBHAM','MCA')";
            String update = "UPDATE JDBC SET lname='suraj' where usn='1CR22MC090'";
            stmt1 = conn.createStatement();
            s1 = conn.setSavepoint("spl");
            stmt2=conn.createStatement();
            stmt1.executeUpdate(insert);
            stmt2.executeUpdate(update);
            conn.commit();
            conn.releaseSavepoint(s1);

            conn.close();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
