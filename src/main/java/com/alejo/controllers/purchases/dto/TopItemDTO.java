package com.alejo.controllers.purchases.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TopItemDTO {
    private Integer itemId;
    private String itemName;
    private Integer quantitySold;
}