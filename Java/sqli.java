// simple Spring Boot application that uses JDBC to query a database


package com.example.sqlinjectiondemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
        String password = "dummy";  // Example password, this could be replaced with user input.
        
        try {
            // Vulnerable: Directly concatenating user input into the SQL query (SQL Injection)
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password");
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                return "Welcome " + username;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Invalid login";
    }
}
