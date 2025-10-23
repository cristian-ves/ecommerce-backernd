package com.alejo.service.cart;

import com.alejo.entities.cart.CartItem;

import java.util.Optional;

public interface ICartItemService {

    Optional<CartItem> addItemToCart(CartItem cartItem);

}
