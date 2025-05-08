package com.example.contactmanagement.service;

import com.example.contactmanagement.dao.ContactDAO;
import com.example.contactmanagement.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactDAO contactDAO;

    public List<Contact> getAllContacts() {
        return contactDAO.findAll();
    }

    public void addContact(Contact contact) {
        contactDAO.save(contact);
    }
}
