package com.alejo.service.purchases;

import com.alejo.controllers.cart.dto.CartItemDTO;
import com.alejo.controllers.purchases.dto.PurchaseDTO;
import com.alejo.controllers.purchases.dto.TopItemDTO;
import com.alejo.controllers.purchases.dto.TopSellerDTO;
import com.alejo.controllers.purchases.dto.TopSellerItemsDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface IPurchaseService {
    PurchaseDTO createPurchase(Integer userId, Integer cardId, List<CartItemDTO> items);
    List<PurchaseDTO> getPurchasesByUserId(Integer userId);
    List<PurchaseDTO> findAll();

    void markAsDelivered(Integer purchaseId);

    Optional<PurchaseDTO> updateDeliveryDate(Integer purchaseId, LocalDateTime newDate);

    List<TopItemDTO> getTopSellingItems(LocalDateTime start, LocalDateTime end);

    List<TopSellerDTO> getTopEarningUsers(LocalDateTime start, LocalDateTime end);

    List<TopSellerItemsDTO> getTopSellersByItemsSold(LocalDateTime start, LocalDateTime end);

}
