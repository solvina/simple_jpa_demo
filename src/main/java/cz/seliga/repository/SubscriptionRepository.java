package cz.seliga.repository;

import cz.seliga.value.Subscription;
import org.springframework.data.repository.CrudRepository;

/**
 * Accessing the storage with {@link Subscription}
 */
public interface SubscriptionRepository extends CrudRepository<Subscription, Long>{
}
