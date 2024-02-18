package com.example.bikeraceapplication.dao;

import com.example.bikeraceapplication.contacts.EmailMessage;

import java.util.List;

public interface EmailDAO {

    void save(EmailMessage message);

    List<EmailMessage> findAll();

}
