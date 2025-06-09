package com.java.career.main;

import java.sql.Timestamp;
import java.util.List;

import com.java.career.dao.CareerCrafterDAO;
import com.java.career.dao.CareerCrafterDAOImpl;
import com.java.career.models.User;

public class Main {
    public static void main(String[] args) {
        CareerCrafterDAO dao = new CareerCrafterDAOImpl();

        // Insert a user
        User user = new User();
        user.setId(1);
        user.setName("Alice");
        user.setEmail("alice@example.com");
        user.setPassword("password123");
        user.setRole("job_seeker");
        user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        dao.insertUser(user);

        // Fetch and print all users
        List<User> users = dao.getAllUsers();
        for (User u : users) {
            System.out.println("User ID: " + u.getId());
            System.out.println("Name: " + u.getName());
            System.out.println("Email: " + u.getEmail());
            System.out.println("Role: " + u.getRole());
            System.out.println("Created At: " + u.getCreatedAt());
            System.out.println("----------------------");
        }
    }
}
