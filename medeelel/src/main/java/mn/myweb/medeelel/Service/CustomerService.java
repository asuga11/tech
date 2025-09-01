package mn.myweb.medeelel.Service;

import mn.myweb.medeelel.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Optional<Customer> getCustomerById(Long id);
    Customer saveCustomer(Customer customer);
    void deleteCustomer(Long id);
    Optional<Customer> getCustomerByEmail(String email);
}
