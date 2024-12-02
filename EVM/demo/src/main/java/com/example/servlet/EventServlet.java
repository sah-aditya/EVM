package com.example.servlet;

import com.example.dao.EventDAO;
import com.example.model.Event;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;*/
import java.io.IOException;

@WebServlet("/events")
public class EventServlet extends HttpServlet {
    private EventDAO eventDAO;

    @Override
    public void init() {
        eventDAO = new EventDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String date = request.getParameter("date");

        Event event = new Event();
        event.setTitle(title);
        event.setDate(date);

        eventDAO.addEvent(event);
        response.sendRedirect("eventList.jsp"); // Redirect to eventList.jsp after adding an event
    }
}