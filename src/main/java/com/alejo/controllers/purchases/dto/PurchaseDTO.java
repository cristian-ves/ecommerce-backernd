package com.alejo.controllers.purchases.dto;

import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PurchaseDTO {
    private Integer purchaseId;
    private Integer userId;
    private Integer cardId;
    private LocalDateTime deliveryDate;
    private boolean delivered;
    private double total;
    private LocalDateTime createdAt;
    private List<ItemPurchasedDTO> items;
}
