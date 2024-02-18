package com.example.bikeraceapplication.contacts;

public class EmailMessage {

    private Email from;
    private Email to;
    private String subject;
    private String body;

    public EmailMessage(){}

    public Email getFrom() {
        return from;
    }

    public void setFrom(Email from) {
        this.from = from;
    }

    public Email getTo() {
        return to;
    }

    public void setTo(Email to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
