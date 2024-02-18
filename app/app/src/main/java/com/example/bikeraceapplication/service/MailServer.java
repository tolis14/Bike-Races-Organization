package com.example.bikeraceapplication.service;

import com.example.bikeraceapplication.contacts.Email;
import com.example.bikeraceapplication.contacts.EmailMessage;
import com.example.bikeraceapplication.dao.EmailDAO;
import com.example.bikeraceapplication.memorydao.EmailDAOMemory;


public class MailServer implements EmailProvider{

    private EmailDAO emailDAO;

    private final Email EMAIL_ADDRESS = new Email("bikeRaceApplication@gmail.com");

    private static MailServer mailServerInstance = null;

    private MailServer(){

        emailDAO = new EmailDAOMemory();
    }

    @Override
    public void sendEmail(EmailMessage message) {
        emailDAO.save(message);
    }

    @Override
    public Email getAddress() {
        return EMAIL_ADDRESS;
    }

    public static MailServer getInstance(){

        if(mailServerInstance == null)
            mailServerInstance = new MailServer();

        return mailServerInstance;
    }

}
