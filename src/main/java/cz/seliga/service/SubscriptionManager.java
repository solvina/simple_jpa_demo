package cz.seliga.service;

import cz.seliga.repository.SubscriptionRepository;
import cz.seliga.value.Subscription;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class SubscriptionManager {
    private final SubscriptionRepository subscriptionRepository;

    @Autowired
    public SubscriptionManager(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public Subscription saveOrUpdate(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Nullable
    public Optional<Subscription> findById(long id) {
        return subscriptionRepository.findById(id);
    }

    public Iterable<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }
}
