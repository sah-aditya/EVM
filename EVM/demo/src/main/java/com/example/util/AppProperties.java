package com.example.util;

import java.util.Properties;

public class AppProperties {
    private Properties properties;

    public AppProperties() {
        properties = new Properties();
        // Load properties from a file or set them directly for demonstration
        properties.setProperty("db.url", "jdbc:mysql://localhost:3306/mydb");
        properties.setProperty("db.root", "root");
        properties.setProperty("db.password", "Sarth@2005");
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}