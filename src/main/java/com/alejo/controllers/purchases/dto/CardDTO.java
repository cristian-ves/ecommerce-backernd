package com.alejo.controllers.purchases.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardDTO {
    private Integer id;
    private String number;
    private String expiration;
    private Integer cvv;
    private String name;
    private Integer userId;
}