package com.kibiego.BankApp.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers(){
        return  customerRepository.findAll();
    }

    public void addNewCustomer(Customer customer) {
        Optional<Customer> customerOptional = customerRepository
                .findCustomerByEmail(customer.getEmail());

        if (customerOptional.isPresent()) {
            throw new IllegalStateException("email is taken");
        }

        customerRepository.save(customer);

    }

    public void deleteCustomer(Long customerId) {
        boolean exists = customerRepository.existsById(customerId);
        if (!exists) {
            throw new IllegalStateException("customer with id " + customerId + " does not exist");
        }
        customerRepository.deleteById(customerId);
    }

    @Transactional
    public void updateCustomer(Long customerId,
                               String firstName,
                               String lastName,
                               String email) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalStateException(
                        "customer with id " + customerId + " does not exist"));
        if (firstName != null &&
                firstName.length() > 0 &&
        !Objects.equals(customer.getFirstName(), firstName)){
            customer.setFirstName(firstName);
        }
        if (lastName != null &&
        lastName.length() > 0 &&
        !Objects.equals(customer.getLastName(), lastName)) {
            customer.setLastName(lastName);
        }

        if (email != null &&
        email.length() > 0 &&
        !Objects.equals(customer.getEmail(), email)) {
            Optional<Customer> customerOptional = customerRepository
                    .findCustomerByEmail(email);
            if (customerOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            customer.setEmail(email);
        }

    }
}
