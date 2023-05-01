package cz.seliga.service;

import cz.seliga.repository.CustomerRepository;
import cz.seliga.value.Customer;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class CustomerManager {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerManager(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer saveOrUpdate(Customer customer) {
        return customerRepository.save(customer);
    }

    @Nullable
    public Optional<Customer> findById(long id) {
        return customerRepository.findById(id);
    }

    public Iterable<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }
}
