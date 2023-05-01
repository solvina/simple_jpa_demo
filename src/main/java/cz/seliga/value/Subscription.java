package cz.seliga.value;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(columnDefinition = "DATE")
    private LocalDate startDate;
    /**
     * Validating the validUntil property against startDate would involve the usage of a custom validator
     */
    @Column(columnDefinition = "DATE")
    private LocalDate validUntil;
    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "quotation_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Quotation quotation;

    protected Subscription() {}

    public Subscription(Quotation quotation, LocalDate startDate, LocalDate validUntil) {
        this.quotation = quotation;
        this.startDate = startDate;
        this.validUntil = validUntil;
    }

    public Long getId() {
        return id;
    }

    public Quotation getQuotation() {
        return quotation;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getValidUntil() {
        return validUntil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return Objects.equals(id, that.id) && Objects.equals(quotation, that.quotation) && Objects.equals(startDate, that.startDate) && Objects.equals(validUntil, that.validUntil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quotation, startDate, validUntil);
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", quotation=" + quotation +
                ", startDate=" + startDate +
                ", validUntil=" + validUntil +
                '}';
    }
}
