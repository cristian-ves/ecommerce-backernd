package com.alejo.controllers.purchases;

import com.alejo.controllers.cart.dto.CartItemDTO;
import com.alejo.controllers.purchases.dto.PurchaseDTO;
import com.alejo.service.purchases.IPurchaseService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @GetMapping("/all")
    public ResponseEntity<List<PurchaseDTO>> getAllPurchases() {
        List<PurchaseDTO> purchases = purchaseService.findAll();
        return ResponseEntity.ok(purchases);
    }

    @PutMapping("/{purchaseId}/deliver")
    public ResponseEntity<Void> deliverPurchase(@PathVariable Integer purchaseId) {
        purchaseService.markAsDelivered(purchaseId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{purchaseId}/delivery-date")
    public ResponseEntity<?> updateDeliveryDate(
            @PathVariable Integer purchaseId,
            @RequestBody UpdateDeliveryDateRequest request
    ) {
        try {
            LocalDateTime parsedDate = LocalDate.parse(request.getNewDate())
                    .atStartOfDay();
            var updated = purchaseService.updateDeliveryDate(purchaseId, parsedDate);

            return updated
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body("Error updating delivery date");
        }
    }

    @Data
    public static class UpdateDeliveryDateRequest {
        private String newDate;

        public String getNewDate() {
            return newDate;
        }

        public void setNewDate(String newDate) {
            this.newDate = newDate;
        }
    }


}
