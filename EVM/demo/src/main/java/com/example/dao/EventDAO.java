package com.example.dao;

import com.example.model.Event;
import java.util.ArrayList;
import java.util.List;

public class EventDAO {
    private List<Event> events = new ArrayList<>();

    public void addEvent(Event event) {
        event.setId(events.size() + 1); // Simple ID assignment
        events.add(event);
    }

    public List<Event> getAllEvents() {
        return events;
    }
}