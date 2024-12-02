package com.example;

import com.example.dao.UserDAO;
import com.example.dao.EventDAO;
import com.example.model.User;
import com.example.model.Event;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static UserDAO userDAO = new UserDAO();
    private static EventDAO eventDAO = new EventDAO();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to the Event Management System");
            System.out.println("1. Add User");
            System.out.println("2. Add Event");
            System.out.println("3. Show Users");
            System.out.println("4. Show Events");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = 0;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                scanner.nextLine(); // Clear the invalid input
                continue; // Go back to the beginning of the loop
            }

            switch (choice) {
                case 1:
                    addUser ();
                    break;
                case 2:
                    addEvent();
                    break;
                case 3:
                    showUsers();
                    break;
                case 4:
                    showEvents();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addUser () {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter role (user/organizer): ");
        String role = scanner.nextLine();

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);

        userDAO.addUser (user);
        System.out.println("User  added successfully.");
    }

    private static void addEvent() {
        System.out.print("Enter event title: ");
        String title = scanner.nextLine();

        System.out.print("Enter event date: ");
        String date = scanner.nextLine();

        Event event = new Event();
        event.setTitle(title);
        event.setDate(date);

        eventDAO.addEvent(event);
        System.out.println("Event added successfully.");
    }

    private static void showUsers() {
        System.out.println("List of Users:");
        userDAO.getAllUsers().forEach(u -> {
            System.out.println("User  ID: " + u.getId());
            System.out.println("Name: " + u.getName());
            System.out.println("Email: " + u.getEmail());
            System.out.println("Role: " + u.getRole());
            System.out.println("---------------");
        });
    }

    private static void showEvents() {
        System.out.println("List of Events:");
        eventDAO.getAllEvents().forEach(e -> {
            System.out.println("Event ID: " + e.getId());
            System.out.println("Title: " + e.getTitle());
            System.out.println("Date: " + e.getDate());
            System.out.println("---------------");
        });
    }
}