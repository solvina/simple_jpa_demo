package cz.seliga.rest;


import cz.seliga.service.QuotationManager;
import cz.seliga.value.Quotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuotationResource {
    private final QuotationManager quotationManager;

    @Autowired
    public QuotationResource(QuotationManager  quotationManager) {
        this. quotationManager =  quotationManager;
    }

    @GetMapping("/quotations/{id}")
    public ResponseEntity<Quotation> getQuotation(@PathVariable long id) {
        return  quotationManager.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/quotations")
    public ResponseEntity<Iterable<Quotation>> getAllQuotation()
    {
        return ResponseEntity.ok(quotationManager.getAllQuotations());
    }

    @PostMapping("/quotations")
    public ResponseEntity<Quotation> createQuotation(@RequestBody Quotation quotation)
    {
        if(quotation.getId() == null)
            return ResponseEntity.ok(quotationManager.saveOrUpdate(quotation));

        return ResponseEntity.badRequest().build();
    }
}
