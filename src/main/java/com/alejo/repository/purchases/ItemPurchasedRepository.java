package com.alejo.repository.purchases;

import com.alejo.entities.auth.User;
import com.alejo.entities.purchases.ItemPurchased;
import com.alejo.entities.purchases.Purchase;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ItemPurchasedRepository extends CrudRepository<ItemPurchased, Integer> {

    List<ItemPurchased> findByUser(User user);
    List<ItemPurchased> findByPurchase(Purchase purchase);

    @Query("""
        SELECT ip.item, SUM(ip.quantity) as totalSold
        FROM ItemPurchased ip
        WHERE ip.purchase.createdAt BETWEEN :start AND :end
        GROUP BY ip.item
        ORDER BY totalSold DESC
    """)
    List<Object[]> findTopSellingItems(@Param("start") LocalDateTime start,
                                       @Param("end") LocalDateTime end);

    @Query("""
        SELECT ip.item.user.id AS sellerId,
               ip.item.user.name AS sellerName,
               SUM(ip.item.price * ip.quantity) AS totalEarnings
        FROM ItemPurchased ip
        WHERE ip.purchase.createdAt BETWEEN :start AND :end
        GROUP BY ip.item.user.id, ip.item.user.name
        ORDER BY totalEarnings DESC
    """)
    List<Object[]> findTopSellersByEarnings(@Param("start") LocalDateTime start,
                                            @Param("end") LocalDateTime end);

    @Query("""
    SELECT ip.item.user, SUM(ip.quantity) as totalSold
    FROM ItemPurchased ip
    WHERE ip.purchase.createdAt BETWEEN :start AND :end
    GROUP BY ip.item.user
    ORDER BY totalSold DESC
""")
    List<Object[]> findTopSellersByItemsSold(
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end
    );


}
