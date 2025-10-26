package com.alejo.entities.purchases;

import com.alejo.entities.auth.User;
import com.alejo.entities.items.Item;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Entity
@Table(name = "item_purchased")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemPurchased {

    @EmbeddedId
    private ItemPurchasedId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("user")
    @JoinColumn(name = "usr", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("item")
    @JoinColumn(name = "item", nullable = false)
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("purchase")
    @JoinColumn(name = "purchase", nullable = false)
    private Purchase purchase;

    @Column(nullable = false)
    private Integer quantity = 0;

    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ItemPurchasedId implements Serializable {
        @Column(name = "usr")
        private Integer user;

        @Column(name = "item")
        private Integer item;

        @Column(name = "purchase")
        private Integer purchase;
    }
}
