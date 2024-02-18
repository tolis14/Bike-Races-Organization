package com.example.bikeraceapplication.contacts;

public class Email {

    private String address;

    public Email(String address){
        this.address = address;
    }

    public String getAddress(){
        return  this.address;
    }

    @Override
    public boolean equals(Object other){
        if(other == null) return false;

        if(other == this) return true;

        if(!(other instanceof Email)) return false;

        return this.address.equals(((Email) other).address);
    }

    @Override
    public int hashCode(){
        return address.hashCode();
    }

    @Override
    public String toString(){
        return this.address;
    }
}
