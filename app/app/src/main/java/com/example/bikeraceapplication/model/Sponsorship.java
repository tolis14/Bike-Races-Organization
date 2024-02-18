package com.example.bikeraceapplication.model;

public class Sponsorship {
    private String description;
    private boolean isPaid;

    public Sponsorship(){}

    public Sponsorship(String description) {
        this.description = description;
        this.setPaid(false);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}
