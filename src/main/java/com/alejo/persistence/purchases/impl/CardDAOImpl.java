package com.alejo.persistence.purchases.impl;

import com.alejo.controllers.purchases.dto.CardDTO;
import com.alejo.entities.auth.User;
import com.alejo.entities.purchases.Card;
import com.alejo.persistence.purchases.ICardDAO;
import com.alejo.repository.auth.UserRepository;
import com.alejo.repository.purchases.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CardDAOImpl implements ICardDAO {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public CardDTO saveCard(CardDTO cardDTO) {
        User user = userRepository.findById(cardDTO.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Card card = Card.builder()
                .number(cardDTO.getNumber())
                .expiration(cardDTO.getExpiration())
                .cvv(cardDTO.getCvv())
                .name(cardDTO.getName())
                .user(user)
                .build();

        card = cardRepository.save(card);
        cardDTO.setId(card.getId());
        return cardDTO;
    }

    @Override
    public List<CardDTO> findAllbyUserId(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        return cardRepository.findByUser(user)
                .stream()
                .map(c -> new CardDTO(c.getId(), c.getNumber(), c.getExpiration(), c.getCvv(), c.getName(), id))
                .collect(Collectors.toList());
    }
}
