package com.example.bikeraceapplication.memorydao;

import com.example.bikeraceapplication.contacts.EmailMessage;
import com.example.bikeraceapplication.dao.EmailDAO;

import java.util.ArrayList;
import java.util.List;

public class EmailDAOMemory implements EmailDAO {

    private static ArrayList<EmailMessage> emailMessages = new ArrayList<>();

    @Override
    public void save(EmailMessage message) {
        emailMessages.add(message);
    }

    @Override
    public List<EmailMessage> findAll() {
        return emailMessages;
    }


}
