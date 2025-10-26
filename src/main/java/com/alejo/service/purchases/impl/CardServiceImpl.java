package com.alejo.service.purchases.impl;

import com.alejo.controllers.purchases.dto.CardDTO;
import com.alejo.controllers.purchases.dto.CardResponseDTO;
import com.alejo.persistence.purchases.ICardDAO;
import com.alejo.service.purchases.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements ICardService {

    @Autowired
    private ICardDAO cardDAO;


    @Override
    public CardDTO saveCard(CardDTO cardDTO) {
        return cardDAO.saveCard(cardDTO);
    }

    @Override
    public List<CardResponseDTO> getCardsByUserId(Integer id) {
        return cardDAO.findAllbyUserId(id);
    }
}
