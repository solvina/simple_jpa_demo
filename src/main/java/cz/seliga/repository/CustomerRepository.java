package cz.seliga.repository;

import cz.seliga.value.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Accessing the storage with Customer
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
