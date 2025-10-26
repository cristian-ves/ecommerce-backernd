package com.alejo.controllers.purchases.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PurchaseResponseDTO {
    private Integer purchaseId;
    private Integer userId;
    private Integer cardId;
    private Integer totalItems;
    private LocalDateTime createdAt;
}