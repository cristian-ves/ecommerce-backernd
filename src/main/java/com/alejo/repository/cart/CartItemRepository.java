package com.alejo.repository.cart;

import com.alejo.entities.cart.CartItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends CrudRepository<CartItem, CartItem.CartItemId> {

    List<CartItem> findByUser_Id(Integer id);
    void deleteAllByUser_Id(Integer id);

}
