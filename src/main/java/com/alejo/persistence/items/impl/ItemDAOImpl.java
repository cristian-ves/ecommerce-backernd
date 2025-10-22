package com.alejo.persistence.items.impl;

import com.alejo.entities.items.Item;
import com.alejo.persistence.items.IItemDAO;
import com.alejo.repository.items.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemDAOImpl implements IItemDAO {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> findPaginatedItems(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("Id").ascending());
        Page<Item> items = itemRepository.findAllByAcceptedTrueAndUser_SuspendedFalse(pageable);
        return items.getContent();
    }

    @Override
    public List<Item> search(String query) {
        return itemRepository.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(query, query);
    }

    @Override
    public List<Item> findByCategories(List<Integer> categories) {
        return itemRepository.findByCategoryIdIn(categories);
    }


}
