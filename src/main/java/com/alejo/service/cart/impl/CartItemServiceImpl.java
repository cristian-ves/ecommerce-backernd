package com.alejo.service.cart.impl;

import com.alejo.controllers.cart.dto.CartItemDetailsDTO;
import com.alejo.controllers.items.dto.CategoryDTO;
import com.alejo.controllers.items.dto.ItemDTO;
import com.alejo.entities.cart.CartItem;
import com.alejo.persistence.cart.ICartItemDAO;
import com.alejo.service.cart.ICartItemService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Override
    public List<CartItemDetailsDTO> getCartByUserId(int userId) {
        return cartItemDAO.findAllByUserId(userId)
                .stream()
                .map(cartItem -> CartItemDetailsDTO.builder()
                        .item(ItemDTO.builder()
                                .id(cartItem.getItem().getId())
                                .name(cartItem.getItem().getName())
                                .description(cartItem.getItem().getDescription())
                                .image(cartItem.getItem().getImage())
                                .price(cartItem.getItem().getPrice())
                                .isNew(cartItem.getItem().isNew())
                                .rating(cartItem.getItem().getRating())
                                .rates(cartItem.getItem().getRates())
                                .stock(cartItem.getItem().getStock())
                                .category(CategoryDTO.builder()
                                        .id(cartItem.getItem().getCategory().getId())
                                        .name(cartItem.getItem().getCategory().getName())
                                        .build())
                                .build())
                        .quantity(cartItem.getQuantity())
                        .build())
                .toList();
    }

    @Override
    public boolean decrementItemFromCart(int userId, int itemId) {
        CartItem.CartItemId id = new CartItem.CartItemId(userId, itemId);
        Optional<CartItem> existing = cartItemDAO.findById(id);
        if (existing.isPresent()) {
            CartItem cartItem = existing.get();
            if (cartItem.getQuantity() > 1) {
                cartItem.setQuantity(cartItem.getQuantity() - 1);
                cartItemDAO.save(cartItem);
            } else {
                cartItemDAO.delete(cartItem);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteItemFromCart(int userId, int itemId) {
        CartItem.CartItemId id = new CartItem.CartItemId(userId, itemId);
        Optional<CartItem> existing = cartItemDAO.findById(id);
        if (existing.isPresent()) {
            cartItemDAO.delete(existing.get());
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public void clearCart(int userId) {
        cartItemDAO.deleteAllByUserId(userId);
    }

}
