package com.example.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            String url = "jdbc:mysql://localhost:3306/event_management";
            String user = "root"; // replace with your MySQL username
            String password = "Sarth@2005"; // replace with your MySQL password
            connection = DriverManager.getConnection(url, user, password);
        }
        return connection;
    }
}