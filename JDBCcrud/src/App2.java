import java.io.BufferedReader;
import java.io.*;
import java.sql.*;
import java.util.*;

public class App2 {

    public static void main(String[] args) {

// Open a connection
try(Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/college1?autoReconnect=true&useSSL=false","root","1234");
   Statement stmt = conn.createStatement();
) {              
    try {
        String create = "CREATE TABLE STUDENT "+
                         "(usn VARCHAR(14) not null, "+
                         "first varchar(12) not null, "+
                         "second varchar(14) not  null, "+
                         "cource VARCHAR(6) not null, "+
                         "primary key (usn))";
        stmt.executeUpdate(create);
        System.out.println("\n Tbale Created");   
    }       
    catch(SQLException e) {
        System.out.println("Tabke already exists");
    }
    while(true) {
        System.out.println("Enter your choice:\n1. Insert new value\n2. Update value by USN\n3. Delete value by USN\n4. Print Table\n9. Exit the loop");
        Scanner s = new Scanner(System.in);
        int choice = s.nextInt();
        switch(choice) {
            case 1:
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("USN: ");
                String usn = sc.nextLine();
                System.out.println("First Name: ");
                String fname = sc.nextLine();
                System.out.println("Last Name: ");
                String lname = sc.nextLine();
                System.out.println("Cource(MCA/MBA)");
                String crs = sc.nextLine();
                String insert = "insert into Student values('" +usn + "','" + fname + "','" + lname + "','" + crs + "')";
                stmt.executeUpdate(insert);
                System.out.println("Value Inserted.. :)");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            break;

            case 2:
    try {
        Scanner sc = new Scanner(System.in);
        System.out.println("USN: ");
        String usn = sc.nextLine();
        System.out.println("First Name: ");
        String fname = sc.nextLine();
        System.out.println("Last Name: ");
        String lname = sc.nextLine();
        System.out.println("Course (MCA/MBA): ");
        String crs = sc.nextLine();
        String update = "update student set first='" + fname +"', second='" + lname + "', course='" + crs + "' where usn = '" + usn + "'";
        System.out.println(update + "\n\n");
        stmt.executeUpdate(update);
        System.out.println("Value Updated.. :)");
    } catch (SQLException e) {
        e.printStackTrace();
    }
    break;


            case 3:
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("USN: ");
                String usn = sc.nextLine();
                String delete = "delete from student where usn='"+usn+"'";
                stmt.executeUpdate(delete);
                System.out.println("Value deleted... :)");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            break;
            case 4:
            ResultSet rs = stmt.executeQuery("select * from Student");
            if(rs.next()) {
                System.out.println("USN\t\tFirst Name\t\tSecond Name\t\t,Couse");
                do {
                    String usn = rs.getString(1);
                    String fn = rs.getString(2);
                    String ln = rs.getString(3);
                    String c = rs.getString(4);
                    System.out.println(usn+"\t"+fn+"\t"+ln+"\t"+c);
                }
                while(rs.next());
            }
            else
            System.out.println("Records are not avilable in the DB");
            break;
            case 9:
            System.exit(1);
            break;

            default:
                System.out.println("Wrong Input");
                break;
        }
    }



} catch (SQLException e) {
   e.printStackTrace();
}
}
}