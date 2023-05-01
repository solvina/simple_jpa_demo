package cz.seliga.rest;

import cz.seliga.service.SubscriptionManager;
import cz.seliga.value.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SubscriptionResource {

    private final SubscriptionManager subscriptionManager;

    @Autowired
    public SubscriptionResource(SubscriptionManager subscriptionManager) {
        this.subscriptionManager = subscriptionManager;
    }

    @GetMapping("/subscriptions/{id}")
    public ResponseEntity<Subscription> getSubscription(@PathVariable long id) {
        return  subscriptionManager.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/subscriptions")
    public ResponseEntity<Iterable<Subscription>> getAllSubscriptions() {
        return ResponseEntity.ok(subscriptionManager.getAllSubscriptions());
    }

    @PostMapping("/subscriptions")
    public ResponseEntity<Subscription> createSubscription(@RequestBody Subscription subscription)
    {
        return ResponseEntity.ok(subscriptionManager.saveOrUpdate(subscription));
    }
}
