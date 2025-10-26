package com.alejo.persistence.purchases;

import com.alejo.controllers.cart.dto.CartItemDTO;
import com.alejo.controllers.purchases.dto.PurchaseDTO;

import java.util.List;

public interface IPurchaseDAO {
    PurchaseDTO createPurchase(Integer userId, Integer cardId, List<CartItemDTO> items);

    List<PurchaseDTO> findByUserId(Integer userId);
}
