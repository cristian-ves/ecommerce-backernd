package com.alejo.persistence.purchases;

import com.alejo.controllers.purchases.dto.CardDTO;

import java.util.List;

public interface ICardDAO {
    CardDTO saveCard(CardDTO cardDTO);
    List<CardDTO> findAllbyUserId(Integer id);
}
