package com.alejo.repository.items;

import com.alejo.entities.items.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends PagingAndSortingRepository<Item, Integer> {

    Page<Item> findAllByAcceptedTrueAndUser_SuspendedFalse(Pageable pageable);

}
