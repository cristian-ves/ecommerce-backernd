package com.alejo.controllers.cart;

import com.alejo.controllers.cart.dto.CartItemDTO;
import com.alejo.controllers.cart.dto.CartItemDetailsDTO;
import com.alejo.entities.auth.User;
import com.alejo.entities.items.Item;
import com.alejo.entities.cart.CartItem;
import com.alejo.service.auth.IUserService;
import com.alejo.service.items.IItemService;
import com.alejo.service.cart.ICartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartItemController {

    @Autowired
    private ICartItemService cartItemService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IItemService itemService;

    @PostMapping("/add")
    public CartItemDTO addToCart(@RequestBody CartItemDTO cartItemDTO) {
        User user = userService.findById(cartItemDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Item item = itemService.findById(cartItemDTO.getItemId())
                .orElseThrow(() -> new RuntimeException("Item not found"));

        CartItem cartItem = CartItem.builder()
                .user(user)
                .item(item)
                .quantity(1)
                .build();

        CartItem saved = cartItemService.addItemToCart(cartItem)
                .orElseThrow(() -> new RuntimeException("Error saving cart item"));

        return CartItemDTO.builder()
                .userId(saved.getUser().getId())
                .itemId(saved.getItem().getId())
                .quantity(saved.getQuantity())
                .build();
    }

    @GetMapping("/user/{userId}")
    public List<CartItemDetailsDTO> getUserCart(@PathVariable int userId) {
        return cartItemService.getCartByUserId(userId);
    }

    @DeleteMapping("/decrement")
    public String removeFromCart(@RequestParam int userId, @RequestParam int itemId) {
        boolean success = cartItemService.decrementItemFromCart(userId, itemId);
        if (success) return "Item decremented successfully";
        else return "Item not found in cart";
    }

    @DeleteMapping("/delete")
    public String deleteFromCart(@RequestParam int userId, @RequestParam int itemId) {
        boolean success = cartItemService.deleteItemFromCart(userId, itemId);
        if (success) return "Item deleted successfully";
        else return "Item not found in cart";
    }

    @DeleteMapping("/clear")
    public String clearCart(@RequestParam int userId) {
        cartItemService.clearCart(userId);
        return "Cart cleared successfully";
    }

}
