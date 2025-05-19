package com.mypack;

public class Contact {
    private int contactid;
    private String firstname;
    private String lastname;
    private String number;
    private String email;
    private String address;
    private String category;
    
    public Contact() {}

    public Contact(int contactid, String firstname, String lastname, String number, String email, String address, String category) {
        this.contactid = contactid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.number = number;
        this.email = email;
        this.address = address;
        this.category = category;
    }

    public int getContactid() {
        return contactid;
    }
    public void setContactid(int contactid) {
        this.contactid = contactid;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
}
