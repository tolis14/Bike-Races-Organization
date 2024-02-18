package com.example.bikeraceapplication.memorydao;

import com.example.bikeraceapplication.dao.UserDAO;
import com.example.bikeraceapplication.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAOMemory implements UserDAO {

    private static ArrayList<User> users = new ArrayList<>();

    @Override
    public User findbyid(String id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public void save(User user) {
        users.add(user);
    }

    @Override
    public User find(String email, String password) {
        for (User user : users) {
            if (user.getPassword().equals(password) && user.getEmail().getAddress().equals(email))
                return user;
        }
        return null;
    }

    @Override
    public User findByEmail(String email) {

        for(User user : users){
            if(user.getEmail().getAddress().equals(email))
                return user;
        }
        return null;
    }

    @Override
    public void clear() {
        users.clear();
    }


}
