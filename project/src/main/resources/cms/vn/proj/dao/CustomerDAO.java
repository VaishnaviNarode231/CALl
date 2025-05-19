package cms.vn.proj.dao;


import java.util.List;
import com.yourcompany.crm.entity.Customer;

public interface CustomerDAO {
    List<Customer> getCustomers();
    void saveCustomer(Customer customer);
    Customer getCustomer(int id);
    void deleteCustomer(int id);
}
