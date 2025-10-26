package com.alejo.service.purchases.impl;

import com.alejo.controllers.cart.dto.CartItemDTO;
import com.alejo.controllers.purchases.dto.PurchaseDTO;
import com.alejo.persistence.purchases.IPurchaseDAO;
import com.alejo.service.purchases.IPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl implements IPurchaseService {

    @Autowired
    private IPurchaseDAO purchaseDAO;

    @Override
    public PurchaseDTO createPurchase(Integer userId, Integer cardId, List<CartItemDTO> items) {
        return purchaseDAO.createPurchase(userId, cardId, items);
    }

    @Override
    public List<PurchaseDTO> getPurchasesByUserId(Integer userId) {
        return purchaseDAO.findByUserId(userId);
    }
}
