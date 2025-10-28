package com.alejo.controllers.purchases.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopSellerDTO {
    private Integer sellerId;
    private String sellerName;
    private Double totalEarnings;
}