package com.alejo.controllers.purchases;

import com.alejo.controllers.purchases.dto.CardDTO;
import com.alejo.service.purchases.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    private ICardService cardService;

    @PostMapping
    public ResponseEntity<CardDTO> saveCard(@RequestBody CardDTO cardDTO) {
        CardDTO savedCard = cardService.saveCard(cardDTO);
        return ResponseEntity.ok(savedCard);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<CardDTO>> getCards(@PathVariable Integer userId) {

        return ResponseEntity.ok(cardService.getCardsByUserId(userId));

    }

}
