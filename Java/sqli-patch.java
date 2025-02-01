// we should use Prepared Statements instead of directly concatenating user input into the SQL query.
// inserting placeholders for username and password values

package com.example.sqlinjectiondemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

@SpringBootApplication
public class SqlInjectionDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SqlInjectionDemoApplication.class, args);
    }
}

@RestController
class UserController {

    @GetMapping("/user")
    public String getUser(@RequestParam String username) {
        String password = "dummy";  // Example password, could be replaced with user input.
        
        try {
            // Remediated: Using Prepared Statement (prevents SQL Injection)
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password");
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);  // Safe insertion of username into query
            stmt.setString(2, password);  // Safe insertion of password into query
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return "Welcome " + username;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Invalid login";
    }
}
