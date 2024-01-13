import java.io.BufferedReader;
import java.io.*;
import java.sql.*;

public class BatchInsert {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/college1?autoReconnect=true&useSSL=false", "root", "1234")) {
            try (Statement stmt = conn.createStatement()) {
                String sql = "CREATE TABLE BATCH " +
                             "(id INTEGER not null," +
                             "fname VARCHAR(12) not null )";

                stmt.executeUpdate(sql);
                System.out.println("Created table in the given database...");
            }

            // Perform batch insert
            String insertQuery = "INSERT INTO BATCH (id, fname) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = conn.prepareStatement(insertQuery)) {
                // Loop to add 10 rows to the batch
                for (int i = 1; i <= 10; i++) {
                    preparedStatement.setInt(1, i);             // Setting value for 'id'
                    preparedStatement.setString(2, "Name" + i); // Setting value for 'fname'
                    preparedStatement.addBatch();               // Add the current set of values to the batch
                }

                // Execute the batch
                int[] result = preparedStatement.executeBatch();

                // Check the result for successful inserts
                for (int i = 0; i < result.length; i++) {
                    if (result[i] == PreparedStatement.SUCCESS_NO_INFO || result[i] == PreparedStatement.EXECUTE_FAILED) {
                        System.out.println("Error at index " + i);
                    } else {
                        System.out.println("Row " + i + " inserted successfully.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
