package com.alejo.persistence.cart;

import com.alejo.entities.cart.CartItem;

import java.util.List;
import java.util.Optional;

public interface ICartItemDAO {
    CartItem save(CartItem cartItem);
    Optional<CartItem> findById(CartItem.CartItemId id);
    List<CartItem> findAllByUserId(Integer userId);
    void delete(CartItem cartItem);
    void deleteAllByUserId(Integer userId);
}
