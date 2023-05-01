package cz.seliga.repository;

import cz.seliga.value.Quotation;
import org.springframework.data.repository.CrudRepository;

public interface QuotationRepository extends CrudRepository<Quotation, Long> {
}
