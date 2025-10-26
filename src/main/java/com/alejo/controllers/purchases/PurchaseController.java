package com.alejo.controllers.purchases;

import com.alejo.controllers.cart.dto.CartItemDTO;
import com.alejo.controllers.purchases.dto.PurchaseDTO;
import com.alejo.service.purchases.IPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private IPurchaseService purchaseService;

    @PostMapping
    public ResponseEntity<PurchaseDTO> createPurchase(@RequestBody PurchaseRequest request) {
        PurchaseDTO purchase = purchaseService.createPurchase(
                request.getUserId(),
                request.getCardId(),
                request.getItems()
        );
        return ResponseEntity.ok(purchase);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PurchaseDTO>> getPurchasesByUser(@PathVariable Integer userId) {
        List<PurchaseDTO> purchases = purchaseService.getPurchasesByUserId(userId);
        return ResponseEntity.ok(purchases);
    }

    public static class PurchaseRequest {
        private Integer userId;
        private Integer cardId;
        private List<CartItemDTO> items;

        public Integer getUserId() { return userId; }
        public void setUserId(Integer userId) { this.userId = userId; }

        public Integer getCardId() { return cardId; }
        public void setCardId(Integer cardId) { this.cardId = cardId; }

        public List<CartItemDTO> getItems() { return items; }
        public void setItems(List<CartItemDTO> items) { this.items = items; }
    }
}
