package cz.seliga;

import cz.seliga.repository.CustomerRepository;
import cz.seliga.repository.QuotationRepository;
import cz.seliga.repository.SubscriptionRepository;
import cz.seliga.value.Customer;
import cz.seliga.value.Quotation;
import cz.seliga.value.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@SpringBootApplication
public class ExampleApplication {

    private static final Logger log = LoggerFactory.getLogger(ExampleApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);
    }

    @Bean
    public CommandLineRunner initDatabase(
            CustomerRepository customerRepository,
            QuotationRepository quotationRepository,
            SubscriptionRepository subscriptionRepository
    ) {
        return args -> {
            List<Customer> customers = List.of(
                    new Customer("Jon", "Doe", null, "jon.doe@email.com", "+123 233 233 233", LocalDate.of(1991, 1, 1)),
                    new Customer(null, null, null, null, null, null)
            );
            List<Quotation> quotations = List.of(
                    new Quotation(
                            Instant.now().plus(1, ChronoUnit.DAYS),
                            LocalDate.of(2023, 5, 1),
                            9999_9999d,
                            customers.get(0)
                    )
            );
            List<Subscription> subscriptions = List.of(
                    new Subscription(
                            quotations.get(0),
                            LocalDate.of(2023, 5, 1),
                            LocalDate.of(2024, 5, 1)

                    )
            );
            customers.forEach(customer ->
                    log.info("Adding new customer: " + customerRepository.save(customer))
            );
            quotations.forEach(quotation ->
                    log.info("Adding new quotation: " + quotationRepository.save(quotation))
            );
            subscriptions.forEach(subscription ->
                    log.info("Adding new subscription: " + subscriptionRepository.save(subscription))
            );
        };
    }
}
