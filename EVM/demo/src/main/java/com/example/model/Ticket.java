package com.example.model;

public class Ticket {
    private int id;
    private int eventId; // Add this field
    private double price; // Add this field
    private int quantity;
    private String eventName;
    
        // Constructor
        public Ticket() {} // Default constructor
    
        public Ticket(int id, String eventName, int quantity) {
            this.id = id;
            this.eventName = eventName;
            this.quantity = quantity;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEventId() { // Add this method
        return eventId;
    }

    public void setEventId(int eventId) { // Add this method
        this.eventId = eventId;
    }

    public double getPrice() { // Add this method
        return price;
    }

    public void setPrice(double price) { // Add this method
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}