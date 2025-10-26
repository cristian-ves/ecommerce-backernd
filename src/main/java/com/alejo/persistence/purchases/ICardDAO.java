package com.alejo.persistence.purchases;

import com.alejo.controllers.purchases.dto.CardDTO;
import com.alejo.controllers.purchases.dto.CardResponseDTO;

import java.util.List;

public interface ICardDAO {
    CardDTO saveCard(CardDTO cardDTO);
    List<CardResponseDTO> findAllbyUserId(Integer id);
}
