package DAO;

import Controller.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Assuming there's a class called User. If not, remove "extends User"
public class Admin extends User {

    // Method to validate username and password from the 'admin' table
    public int validate(String username, String password) {
        int result = 0;

        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM admin WHERE username = ? AND password = ?")) {

            ps.setString(1, username);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    result = 1; // Login successful
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }

        return result;
    }

    // ✅ Main method to test login functionality
    public static void main(String[] args) {
        Admin admin = new Admin();

        // 🔁 Change these values to test login
        String username = "admin1";   // Enter existing username from your DB
        String password = "admin123"; // Enter correct password

        int result = admin.validate(username, password);

        if (result == 1) {
            System.out.println("✅ Login successful!");
        } else {
            System.out.println("❌ Login failed. Invalid credentials.");
        }
    }
}
