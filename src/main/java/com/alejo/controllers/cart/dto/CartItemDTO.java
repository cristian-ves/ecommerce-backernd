package com.alejo.controllers.cart.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDTO {
    private Integer userId;
    private Integer itemId;
    private int quantity;
}
