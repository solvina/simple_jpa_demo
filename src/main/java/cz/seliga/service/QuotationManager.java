package cz.seliga.service;

import cz.seliga.repository.QuotationRepository;
import cz.seliga.value.Quotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class QuotationManager {
    private final QuotationRepository quotationRepository;

    @Autowired
    public QuotationManager(QuotationRepository quotationRepository) {
        this.quotationRepository = quotationRepository;
    }

    public Quotation saveOrUpdate(Quotation quotation)
    {
        return quotationRepository.save(quotation);
    }
    public Optional<Quotation> findById(long id)
    {
        return quotationRepository.findById(id);
    }

    public Iterable<Quotation> getAllQuotations()
    {
        return quotationRepository.findAll();
    }
}
