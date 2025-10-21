package com.alejo.controllers.items;

import com.alejo.controllers.auth.dto.UserDTO;
import com.alejo.controllers.items.dto.CategoryDTO;
import com.alejo.controllers.items.dto.ItemDTO;
import com.alejo.entities.items.Item;
import com.alejo.security.JwtUtils;
import com.alejo.service.items.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private IItemService itemService;

    @Autowired
    private JwtUtils jwtUtils;


    @GetMapping
    public List<ItemDTO> getPaginatedItems(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return itemService.findPaginatedItems(page, size)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private ItemDTO mapToDTO(Item item) {
        return ItemDTO.builder()
                .id(item.getId())
                .name(item.getName())
                .description(item.getDescription())
                .image(item.getImage())
                .price(item.getPrice())
                .isNew(item.isNew())
                .accepted(item.isAccepted())
                .rating(item.getRating())
                .rates(item.getRates())
                .category(CategoryDTO.builder()
                        .id(item.getCategory().getId())
                        .name(item.getCategory().getName())
                        .build())
                .user(UserDTO.builder()
                        .id(item.getUser().getId())
                        .role(item.getUser().getRole())
                        .name(item.getUser().getName())
                        .email(item.getUser().getEmail())
                        .build())
                .build();
    }
}

