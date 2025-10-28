package com.alejo.repository.purchases;

import com.alejo.entities.purchases.Purchase;
import com.alejo.entities.auth.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PurchaseRepository extends CrudRepository<Purchase, Integer> {
    List<Purchase> findByUser_Id(Integer id);
    List<Purchase> findAll();



}
