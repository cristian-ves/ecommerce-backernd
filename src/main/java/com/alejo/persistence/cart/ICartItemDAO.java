package com.alejo.persistence.cart;

import com.alejo.entities.cart.CartItem;

import java.util.Optional;

public interface ICartItemDAO {
    CartItem save(CartItem cartItem);
    Optional<CartItem> findById(CartItem.CartItemId id);
}
