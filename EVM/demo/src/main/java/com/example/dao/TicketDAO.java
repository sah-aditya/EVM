package com.example.dao;

import com.example.model.Ticket;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TicketDAO {
    private Connection connection;

    public TicketDAO() {
        try {
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("db.properties"));
            String url = props.getProperty("db.url");
            String user = props.getProperty("root");
            String password = props.getProperty("Sarth@2005");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addTicket(Ticket ticket) {
        String sql = "INSERT INTO tickets (eventId, price, quantity) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, ticket.getEventId());
            stmt.setDouble(2, ticket.getPrice());
            stmt.setInt(3, ticket.getQuantity());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Ticket> getAllTickets() {
        List<Ticket> tickets = new ArrayList<>();
        String sql = "SELECT * FROM tickets";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Ticket ticket = new Ticket();
                ticket.setId(rs.getInt("id"));
                ticket.setEventId(rs.getInt("eventId"));
                ticket.setPrice(rs.getDouble("price"));
                ticket.setQuantity(rs.getInt("quantity"));
                tickets.add(ticket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tickets;
    }
}