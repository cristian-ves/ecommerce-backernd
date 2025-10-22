package com.alejo.persistence.items;

import com.alejo.entities.items.Item;

import java.util.List;

public interface IItemDAO {
    List<Item> findPaginatedItems(int page, int size);
    List<Item> search(String query);
    List<Item> findByCategories(List<Integer> categories);
}