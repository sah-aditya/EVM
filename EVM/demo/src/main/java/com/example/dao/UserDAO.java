package com.example.dao;

import com.example.model.User;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private List<User> users = new ArrayList<>();

    public void addUser (User user) {
        user.setId(users.size() + 1); 
        users.add(user);
    }

    public List<User> getAllUsers() {
        return users;
    }
}