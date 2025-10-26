package com.alejo.service.purchases;

import com.alejo.controllers.cart.dto.CartItemDTO;
import com.alejo.controllers.purchases.dto.PurchaseDTO;

import java.util.List;

public interface IPurchaseService {
    PurchaseDTO createPurchase(Integer userId, Integer cardId, List<CartItemDTO> items);
    List<PurchaseDTO> getPurchasesByUserId(Integer userId);
}
