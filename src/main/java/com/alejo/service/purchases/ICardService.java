package com.alejo.service.purchases;

import com.alejo.controllers.purchases.dto.CardDTO;

import java.util.List;

public interface ICardService {

    CardDTO saveCard(CardDTO cardDTO);
    List<CardDTO> getCardsByUserId(Integer id);

}
