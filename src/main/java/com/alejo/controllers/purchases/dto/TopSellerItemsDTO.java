package com.alejo.controllers.purchases.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopSellerItemsDTO {
    Integer sellerId;
    String sellerName;
    Integer totalItemsSold;
}
