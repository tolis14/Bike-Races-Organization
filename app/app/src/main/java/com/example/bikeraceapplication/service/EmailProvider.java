package com.example.bikeraceapplication.service;

import com.example.bikeraceapplication.contacts.Email;
import com.example.bikeraceapplication.contacts.EmailMessage;

/*Because our application do not have an actual mail server
* we create an interface so later on we can implement a true
* mail server just by modify the specific implementation
* */

public interface EmailProvider {

    void sendEmail(EmailMessage message);

    Email getAddress();

}
