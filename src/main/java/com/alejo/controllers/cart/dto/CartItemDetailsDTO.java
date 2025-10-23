package com.alejo.controllers.cart.dto;

import com.alejo.controllers.items.dto.ItemDTO;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDetailsDTO {
    private ItemDTO item;
    private int quantity;
}
