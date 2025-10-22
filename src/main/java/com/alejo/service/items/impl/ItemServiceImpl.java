package com.alejo.service.items.impl;

import com.alejo.entities.items.Item;
import com.alejo.persistence.items.IItemDAO;
import com.alejo.service.items.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements IItemService {

    @Autowired
    private IItemDAO itemDAO;

    @Override
    public List<Item> findPaginatedItems(int page, int size) {
        return itemDAO.findPaginatedItems(page, size);
    }

    @Override
    public List<Item> searchItems(String query) {
        return itemDAO.search(query);
    }

    @Override
    public List<Item> findByCategories(List<Integer> categoryIds) {
        return itemDAO.findByCategories(categoryIds);
    }

}
