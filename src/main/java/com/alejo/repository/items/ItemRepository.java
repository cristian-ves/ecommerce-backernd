package com.alejo.repository.items;

import com.alejo.entities.items.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends PagingAndSortingRepository<Item, Integer> {

    Page<Item> findAllByAcceptedTrueAndUser_SuspendedFalse(Pageable pageable);

    List<Item> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String name, String description);

    List<Item> findByCategoryIdIn(List<Integer> ids);

}
