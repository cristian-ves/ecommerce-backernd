package com.alejo.controllers.items.dto;

import com.alejo.controllers.auth.dto.UserDTO;
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
    private boolean isNew = true;
    private CategoryDTO category;
    private UserDTO user;
    private double rating = 0.0;
    private int rates = 0;
    private boolean accepted = false;

}
