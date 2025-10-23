package com.alejo.service.cart;

import com.alejo.controllers.cart.dto.CartItemDetailsDTO;
import com.alejo.entities.cart.CartItem;

import java.util.List;
import java.util.Optional;

public interface ICartItemService {

    Optional<CartItem> addItemToCart(CartItem cartItem);
    List<CartItemDetailsDTO> getCartByUserId(int userId);
    boolean decrementItemFromCart(int userId, int itemId);
    boolean deleteItemFromCart(int userId, int itemId);
    void clearCart(int userId);

}
