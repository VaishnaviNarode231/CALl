package scoe.cm;
import scoe.cm.Dao.ContactDAO;
import scoe.cm.Model.Contact;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import scoe.cm.Util.HibernateUtil;

public class App {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        // Create new Contact
        Contact contact = new Contact();
        contact.setFirstname("nnn");
        contact.setLastname("pp");
        contact.setNumber("1176543210");
        contact.setEmail("nnn@g.com");
        contact.setAddress("123 , kopargaon");
        contact.setCategory("Friend");
        
        // Save Contact
        session.save(contact);
        transaction.commit();

        System.out.println("Contact saved successfully!");

        // Close session
        session.close();
        HibernateUtil.shutdown();
    }
}


