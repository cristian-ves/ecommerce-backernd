package com.alejo.service.cart.impl;

import com.alejo.entities.cart.CartItem;
import com.alejo.persistence.cart.ICartItemDAO;
import com.alejo.service.cart.ICartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartItemServiceImpl implements ICartItemService {

    @Autowired
    private ICartItemDAO cartItemDAO;

    @Override
    public Optional<CartItem> addItemToCart(CartItem cartItem) {
        CartItem.CartItemId id = new CartItem.CartItemId(
                cartItem.getUser().getId(),
                cartItem.getItem().getId()
        );

        Optional<CartItem> existing = cartItemDAO.findById(id);

        CartItem saved;
        if (existing.isPresent()) {
            CartItem existingItem = existing.get();
            existingItem.setQuantity(existingItem.getQuantity() + 1);
            saved = cartItemDAO.save(existingItem);
        } else {
            saved = cartItemDAO.save(cartItem);
        }

        return Optional.of(saved);
    }
}
