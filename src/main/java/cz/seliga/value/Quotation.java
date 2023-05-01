package cz.seliga.value;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Positive;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Quotation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @FutureOrPresent
    @Column(columnDefinition = "TIMESTAMP")
    private Instant beginningOfInsurance;
    @Column(columnDefinition = "DATE")
    private LocalDate dateOfSigningMortgage;
    @Positive
    private double insuredAmount;
    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Customer customer;

    protected Quotation() {}

    public Quotation(Instant beginningOfInsurance, LocalDate dateOfSigningMortgage, double insuredAmount, Customer customer) {
        this.beginningOfInsurance = beginningOfInsurance;
        this.dateOfSigningMortgage = dateOfSigningMortgage;
        this.insuredAmount = insuredAmount;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public Instant getBeginningOfInsurance() {
        return beginningOfInsurance;
    }

    public LocalDate getDateOfSigningMortgage() {
        return dateOfSigningMortgage;
    }

    public double getInsuredAmount() {
        return insuredAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quotation quotation = (Quotation) o;
        return Double.compare(quotation.insuredAmount, insuredAmount) == 0 && Objects.equals(id, quotation.id) && Objects.equals(beginningOfInsurance, quotation.beginningOfInsurance) && Objects.equals(dateOfSigningMortgage, quotation.dateOfSigningMortgage) && Objects.equals(customer, quotation.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, beginningOfInsurance, dateOfSigningMortgage, insuredAmount, customer);
    }

    @Override
    public String toString() {
        return "Quotation{" +
                "id=" + id +
                ", beginningOfInsurance=" + beginningOfInsurance +
                ", dateOfSigningMortgage=" + dateOfSigningMortgage +
                ", insuredAmount=" + insuredAmount +
                ", customer=" + customer +
                '}';
    }
}
