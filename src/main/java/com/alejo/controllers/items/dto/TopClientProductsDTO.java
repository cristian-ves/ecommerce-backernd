package com.alejo.controllers.items.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TopClientProductsDTO {
    private Integer userId;
    private String userName;
    private Integer totalProducts;
}