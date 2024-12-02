package com.example.servlet;

import com.example.dao.TicketDAO;
import com.example.model.Ticket;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ticket")
public class TicketServlet extends HttpServlet {
    private TicketDAO ticketDAO = new TicketDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int eventId = Integer.parseInt(request.getParameter("eventId"));
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        Ticket ticket = new Ticket();
        ticket.setEventId(eventId);
        ticket.setPrice(price);
        ticket.setQuantity(quantity);

        ticketDAO.addTicket(ticket);
        response.sendRedirect("dashboard.html");
    }
}