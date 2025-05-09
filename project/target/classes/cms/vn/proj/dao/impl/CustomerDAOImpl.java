package cms.vn.proj.dao.impl;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yourcompany.crm.dao.CustomerDAO;
import com.yourcompany.crm.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> getCustomers() {
        return entityManager.createQuery("from Customer", Customer.class).getResultList();
    }

    @Override
    public void saveCustomer(Customer customer) {
        entityManager.merge(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        return entityManager.find(Customer.class, id);
    }

    @Override
    public void deleteCustomer(int id) {
        Customer customer = getCustomer(id);
        if (customer != null) {
            entityManager.remove(customer);
        }
    }
}
