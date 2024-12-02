package com.example.dao;

import com.example.util.AppProperties;

public class SomeDAO {
    private AppProperties appProperties;

    public SomeDAO() {
        appProperties = new AppProperties();
    }

    public void connectToDatabase() {
        String dbUrl = appProperties.getProperty("db.url");
        String dbUsername = appProperties.getProperty("db.Username");
        String dbPassword = appProperties.getProperty("db.Password");

        // Use these properties to establish a database connection
        System.out.println("Connecting to database at: " + dbUrl);
        // Add your database connection logic here
    }
}