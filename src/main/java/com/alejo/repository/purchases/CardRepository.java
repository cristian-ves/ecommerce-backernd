package com.alejo.repository.purchases;

import com.alejo.entities.auth.User;
import com.alejo.entities.purchases.Card;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CardRepository extends CrudRepository<Card, Long> {
    List<Card> findByUser(User user);
}
