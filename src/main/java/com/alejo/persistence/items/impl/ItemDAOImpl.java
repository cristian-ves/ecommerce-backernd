package com.alejo.persistence.items.impl;

import com.alejo.controllers.items.dto.ItemDTO;
import com.alejo.entities.items.Category;
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
import java.util.Optional;

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
        return itemRepository.search(query);
    }

    @Override
    public List<Item> findByCategories(List<Integer> categories) {
        return itemRepository.findByCategoryIdInAndAcceptedTrue(categories);
    }

    @Override
    public Optional<Item> findById(int id) {
        return itemRepository.findById(id);
    }

    @Override
    public List<Item> findByUser_Id(int id) {
        return itemRepository.findByUser_Id(id);
    }

    @Override
    public Item save(Item item) {
        itemRepository.save(item);
        return itemRepository.findById(item.getId())
                .orElseThrow(() -> new RuntimeException("Item Not Found"));
    }

    @Override
    public void update(ItemDTO itemDTO) {
        Item existingItem = itemRepository.findById(itemDTO.getId())
                .orElseThrow(() -> new RuntimeException("Item not found with ID: " + itemDTO.getId()));

        existingItem.setName(itemDTO.getName());
        existingItem.setDescription(itemDTO.getDescription());
        existingItem.setImage(itemDTO.getImage());
        existingItem.setPrice(itemDTO.getPrice());
        existingItem.setStock(itemDTO.getStock());
        existingItem.setNew(itemDTO.isNew());

        if (itemDTO.getCategory() != null && itemDTO.getCategory().getId() != null) {
            existingItem.setCategory(
                    Category.builder()
                            .id(itemDTO.getCategory().getId())
                            .name(itemDTO.getCategory().getName())
                            .build()
            );
        }


        itemRepository.save(existingItem);
    }

    @Override
    public void review(ItemDTO itemDTO, double rate) {
        Item existingItem = itemRepository.findById(itemDTO.getId())
                .orElseThrow(() -> new RuntimeException("Item not found with ID: " + itemDTO.getId()));

        existingItem.setRating((existingItem.getRating() * existingItem.getRates() + rate)/(existingItem.getRates() + 1));
        existingItem.setRates(existingItem.getRates() + 1);

        itemRepository.save(existingItem);
    }


}
