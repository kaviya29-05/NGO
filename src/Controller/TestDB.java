package Controller;

import java.sql.Connection;

public class TestDB {
    public static void main(String[] args) {
        Connection con = DB.getConnection();
        if (con != null) {
            System.out.println("Database connected successfully!");
        } else {
            System.out.println("Failed to connect to the database.");
        }
    }
}
