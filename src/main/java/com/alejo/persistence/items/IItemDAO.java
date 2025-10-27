package com.alejo.persistence.items;

import com.alejo.entities.items.Item;

import java.util.List;
import java.util.Optional;

public interface IItemDAO {
    List<Item> findPaginatedItems(int page, int size);
    List<Item> search(String query);
    List<Item> findByCategories(List<Integer> categories);
    Optional<Item> findById(int id);
    List<Item> findByUser_Id(int id);
    Item save(Item item);
}