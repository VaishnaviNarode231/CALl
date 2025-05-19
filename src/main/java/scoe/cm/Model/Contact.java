package scoe.cm.Model;
import jakarta.persistence.*;

@Entity
@Table(name = "contacts")
public class Contact {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contactid;

    private String firstname;
    private String lastname;
    private String number;
    private String email;
    private String address;
    private String category;

    // Getters and Setters
    public int getContactid() { return contactid; }
    public void setContactid(int contactid) { this.contactid = contactid; }

    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}
