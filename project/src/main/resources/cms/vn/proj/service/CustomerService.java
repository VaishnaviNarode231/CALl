package cms.vn.proj.service;


import java.util.List;
import com.yourcompany.crm.entity.Customer;

public interface CustomerService {
    List<Customer> getCustomers();
    void saveCustomer(Customer customer);
    Customer getCustomer(int id);
    void deleteCustomer(int id);
}
