package cz.seliga.rest;

import cz.seliga.service.CustomerManager;
import cz.seliga.value.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerResource {

    private final CustomerManager customerManager;

    @Autowired
    public CustomerResource(CustomerManager customerManager) {
        this.customerManager = customerManager;
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable long id) {
        return customerManager.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/customers")
    public ResponseEntity<Iterable<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerManager.getAllCustomer());
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> createNewCustomer(@RequestBody Customer customer) {
        if (customer.getId() == null)
            return ResponseEntity.ok(customerManager.saveOrUpdate(customer));

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/customers")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        if (customer.getId() == null)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(customerManager.saveOrUpdate(customer));
    }

}
