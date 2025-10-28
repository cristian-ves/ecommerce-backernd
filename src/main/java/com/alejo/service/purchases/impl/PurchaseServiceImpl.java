package com.alejo.service.purchases.impl;

import com.alejo.controllers.cart.dto.CartItemDTO;
import com.alejo.controllers.purchases.dto.*;
import com.alejo.entities.items.Item;
import com.alejo.persistence.purchases.IPurchaseDAO;
import com.alejo.repository.purchases.ItemPurchasedRepository;
import com.alejo.service.purchases.IPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseServiceImpl implements IPurchaseService {

    @Autowired
    private IPurchaseDAO purchaseDAO;
    @Autowired
    private ItemPurchasedRepository itemPurchasedRepository;

    @Override
    public PurchaseDTO createPurchase(Integer userId, Integer cardId, List<CartItemDTO> items) {
        return purchaseDAO.createPurchase(userId, cardId, items);
    }

    @Override
    public List<PurchaseDTO> getPurchasesByUserId(Integer userId) {
        return purchaseDAO.findByUserId(userId);
    }

    @Override
    public List<PurchaseDTO> findAll() {
        return purchaseDAO.findAll();
    }

    @Override
    public void markAsDelivered(Integer purchaseId) {
        purchaseDAO.markAsDelivered(purchaseId);
    }

    @Override
    public Optional<PurchaseDTO> updateDeliveryDate(Integer purchaseId, LocalDateTime newDate) {
        return purchaseDAO.updateDeliveryDate(purchaseId, newDate);
    }

    @Override
    public List<TopItemDTO> getTopSellingItems(LocalDateTime start, LocalDateTime end) {
        List<Object[]> results = itemPurchasedRepository.findTopSellingItems(start, end);
        return results.stream()
                .limit(10)
                .map(o -> new TopItemDTO(
                        ((Item)o[0]).getId(),
                        ((Item)o[0]).getName(),
                        ((Long)o[1]).intValue()
                ))
                .toList();
    }

    @Override
    public List<TopSellerDTO> getTopEarningUsers(LocalDateTime start, LocalDateTime end) {
        return purchaseDAO.findTopEarningUsers(start, end);
    }

    @Override
    public List<TopSellerItemsDTO> getTopSellersByItemsSold(LocalDateTime start, LocalDateTime end) {
        return purchaseDAO.findTopSellersByItemsSold(start, end);
    }

    @Override
    public List<TopClientOrdersDTO> getTopClientsByOrders(LocalDateTime start, LocalDateTime end) {
        return purchaseDAO.findTopClientsByOrders(start, end);
    }


}
