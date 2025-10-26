package com.alejo.service.purchases;

import com.alejo.controllers.purchases.dto.CardDTO;
import com.alejo.controllers.purchases.dto.CardResponseDTO;

import java.util.List;

public interface ICardService {

    CardDTO saveCard(CardDTO cardDTO);
    List<CardResponseDTO> getCardsByUserId(Integer id);

}
