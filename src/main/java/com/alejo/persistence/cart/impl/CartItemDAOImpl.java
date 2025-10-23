package com.alejo.persistence.cart.impl;

import com.alejo.entities.cart.CartItem;
import com.alejo.persistence.cart.ICartItemDAO;
import com.alejo.repository.cart.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CartItemDAOImpl implements ICartItemDAO {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public CartItem save(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    @Override
    public Optional<CartItem> findById(CartItem.CartItemId id) {
        return cartItemRepository.findById(id);
    }
}
