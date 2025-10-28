package com.alejo.controllers.items.dto;

import com.alejo.controllers.auth.dto.UserDTO;
import com.alejo.entities.items.Item;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemDTO {
    private Integer id;
    private String name;
    private String description;
    private String image;
    private double price = 0.0;
    private int stock = 1;
    private boolean isNew = true;
    private CategoryDTO category;
    private UserDTO user;
    private double rating = 0.0;
    private int rates = 0;
    private boolean accepted = false;
    private boolean rejected = false;

    public static ItemDTO fromEntity(Item item) {
        return ItemDTO.builder()
                .id(item.getId())
                .name(item.getName())
                .description(item.getDescription())
                .image(item.getImage())
                .price(item.getPrice())
                .stock(item.getStock())
                .isNew(item.isNew())
                .rating(item.getRating())
                .rates(item.getRates())
                .category(CategoryDTO.builder()
                        .id(item.getCategory().getId())
                        .name(item.getCategory().getName())
                        .build())
                .build();
    }

}
