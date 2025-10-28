package com.alejo.controllers.items.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemRequestDTO {
    private Integer id;
    private String name;
    private String description;
    private String image;
    private Double price;
    private Integer stock;
    private Boolean isNew;
    private Boolean accepted;
    private Boolean rejected;
    private UserRequestDTO user;
}