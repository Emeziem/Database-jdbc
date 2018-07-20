package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class School {
    private Scanner scan;

    public void data() {
        scan = new Scanner(System.in);

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            Create the connection URL
            String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Aptech;integratedSecurity=true;";
//            Establish the connection
            Connection con = DriverManager.getConnection(connectionUrl);
            System.out.println("CONNECTION ESTABLISHED");
//            Input data into the database
            Statement st = (Statement) con.createStatement();
            System.out.print("ENTER STUDENT ID: ");
            int id = scan.nextInt();

            System.out.print("ENTER THE FIRST NAME: ");
            String firstName = scan.next();

            System.out.print("ENTER THE LAST NAME: ");
            String lastName = scan.next();

            System.out.print("ENTER THE COURSE OFFERED: ");
            String course = scan.next();

//            Using SQL Insert Query
            st.executeUpdate("INSERT INTO SCHOLARSHIP VALUES('" + id + "', '"+ firstName +"',  '"+ lastName +"', '"+ course +"')");
//            Display a successfully query
            System.out.println("VALUES INSERTED SUCCESSFULLY...THANK YOU");
        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
            System.err.print("Class Not Found Exception");
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.err.println("SQLException:" + e.getMessage());
            System.out.println("ErrorCode:" + e.getErrorCode());
//            e.printStackTrace();
        }
    }
}
