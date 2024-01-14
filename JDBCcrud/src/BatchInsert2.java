// A simplified version of BatchInsert to the MYSQL DB by inserting values to an existing table. 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchInsert2 {
    public static void main(String[] args) {
        String dburl = "jdbc:mysql://127.0.0.1/college1?autoReconnect=true&useSSL=false";
        String dbuser = "root";
        String dbpass = "1234";
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(dburl, dbuser, dbpass);
            stmt = conn.createStatement();
            conn.setAutoCommit(false);

            String[] queries = {
                        "INSERT INTO JDBC VALUES('1CR22MC001','AMAL','PV','MCA')",
                        "INSERT INTO JDBC VALUES('1CR22MC002','AJILESH','CP','MCA')",
                        "INSERT INTO JDBC VALUES('1CR22MC003','KIRNA','MANI','MCA')"
            };

            for(String i : queries) {
                stmt.addBatch(i);
            }
            stmt.executeBatch();
            System.out.println("Values added");
            conn.commit();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }    
}
