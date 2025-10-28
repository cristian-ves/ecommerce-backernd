package com.alejo.persistence.purchases;

import com.alejo.controllers.cart.dto.CartItemDTO;
import com.alejo.controllers.purchases.dto.PurchaseDTO;
import com.alejo.controllers.purchases.dto.TopSellerDTO;
import com.alejo.controllers.purchases.dto.TopSellerItemsDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface IPurchaseDAO {
    PurchaseDTO createPurchase(Integer userId, Integer cardId, List<CartItemDTO> items);

    List<PurchaseDTO> findByUserId(Integer userId);
    List<PurchaseDTO> findAll();

    void markAsDelivered(Integer purchaseId);

    Optional<PurchaseDTO> updateDeliveryDate(Integer purchaseId, LocalDateTime newDate);

    List<TopSellerDTO> findTopEarningUsers(LocalDateTime start, LocalDateTime end);

    List<TopSellerItemsDTO> findTopSellersByItemsSold(LocalDateTime start, LocalDateTime end);

}
