package com.alejo.controllers.purchases.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CardResponseDTO {
    private Integer id;
    private String last4;
    private Integer userId;
}
