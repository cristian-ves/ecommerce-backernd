package com.alejo.controllers.purchases.dto;

import com.alejo.controllers.cart.dto.CartItemDTO;

import java.util.List;

public class PurchaseRequestDTO {
    private Integer userId;
    private Integer cardId;
    private List<CartItemDTO> items;
}
