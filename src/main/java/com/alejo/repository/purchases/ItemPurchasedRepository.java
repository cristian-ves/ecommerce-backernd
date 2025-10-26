package com.alejo.repository.purchases;

import com.alejo.entities.auth.User;
import com.alejo.entities.purchases.ItemPurchased;
import com.alejo.entities.purchases.Purchase;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemPurchasedRepository extends CrudRepository<ItemPurchased, Integer> {

    List<ItemPurchased> findByUser(User user);
    List<ItemPurchased> findByPurchase(Purchase purchase);

}
