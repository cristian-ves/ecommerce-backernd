package com.alejo.controllers.items;

import com.alejo.controllers.auth.dto.AuthResponseDTO;
import com.alejo.controllers.auth.dto.RegisterRequestDTO;
import com.alejo.controllers.auth.dto.UserDTO;
import com.alejo.controllers.items.dto.CategoryDTO;
import com.alejo.controllers.items.dto.ItemDTO;
import com.alejo.entities.auth.User;
import com.alejo.entities.items.Item;
import com.alejo.security.JwtUtils;
import com.alejo.service.items.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/search")
    public List<ItemDTO> searchItems(@RequestParam("q") String query) {
        return itemService.searchItems(query)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/filter")
    public List<ItemDTO> filterItemsByCategory(@RequestParam List<Integer> categories) {
        List<Item> items = itemService.findByCategories(categories);
        return items.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/user/{userId}")
    public List<ItemDTO> findItemsByUser_Id(@PathVariable int userId) {
        List<Item> items = itemService.findByUser_id(userId);
        return items.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addItem(@RequestBody ItemDTO itemDTO) {
        if (itemDTO.getName() == null || itemDTO.getName().trim().isEmpty() ||
                itemDTO.getDescription() == null || itemDTO.getDescription().trim().isEmpty() ||
                itemDTO.getImage() == null || itemDTO.getImage().trim().isEmpty() ||
                itemDTO.getPrice() <= 0 ||
                itemDTO.getStock() < 1 ||
                itemDTO.getCategory() == null || itemDTO.getCategory().getId() == null) {

            return ResponseEntity.badRequest().body("All fields are mandatory and must be valid");
        }

        try {
            Item item = itemService.save(itemDTO);
            ItemDTO dto = mapToDTO(item);

            return ResponseEntity.status(201).body(dto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
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
                        .suspended(item.getUser().getSuspended())
                        .build())
                .stock(item.getStock())
                .build();
    }
}

