package com.example.contactmanagement.dao;

import com.example.contactmanagement.model.Contact;
import com.example.contactmanagement.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ContactDAO {

    public void saveContact(Contact contact) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(contact);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public Contact getContact(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Contact.class, id);
        }
    }

    public List<Contact> getAllContacts() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Contact", Contact.class).list();
        }
    }

    public void deleteContact(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Contact contact = session.get(Contact.class, id);
            if (contact != null) {
                session.delete(contact);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

	public List<Contact> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(Contact contact) {
		// TODO Auto-generated method stub
		
	}
}
