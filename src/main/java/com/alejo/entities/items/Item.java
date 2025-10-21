package com.alejo.entities.items;

import com.alejo.entities.auth.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "item")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(columnDefinition = "text")
    private String description;

    @Column(nullable = false, length = 255)
    private String image;

    @Column(nullable = false)
    private double price = 0.0;

    @Column(name = "new", nullable = false)
    private boolean isNew = true;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usr", nullable = false)
    private User user;

    @Column(nullable = false)
    private double rating = 0.0;

    @Column(nullable = false)
    private int rates = 0;

    @Column(nullable = false)
    private boolean accepted = false;
}