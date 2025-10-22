package com.alejo.service.items;

import com.alejo.entities.items.Item;

import java.util.List;

public interface IItemService {

    List<Item> findPaginatedItems(int page, int size);
    List<Item> searchItems(String query);
    List<Item> findByCategories(List<Integer> categoryIds);

}
