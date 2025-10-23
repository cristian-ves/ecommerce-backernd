package com.alejo.repository.cart;

import com.alejo.entities.cart.CartItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends CrudRepository<CartItem, CartItem.CartItemId> {


}
