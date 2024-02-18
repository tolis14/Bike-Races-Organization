package com.example.bikeraceapplication.dao;

import com.example.bikeraceapplication.model.User;

import java.util.List;

public interface UserDAO {

    List<User> findAll();

    User findbyid(String id);

    void save(User entity);

    User find(String email, String password);

    User findByEmail(String email);



    void clear();

}
