package com.alejo.controllers.purchases.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopClientOrdersDTO {
    Integer userId;
    String userName;
    Integer totalOrder;
}
