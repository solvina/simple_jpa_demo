package cz.seliga.repository;

import cz.seliga.value.Quotation;
import org.springframework.data.repository.CrudRepository;

/**
 * Accessing the storage with {@link Quotation}
 */
public interface QuotationRepository extends CrudRepository<Quotation, Long> {
}
