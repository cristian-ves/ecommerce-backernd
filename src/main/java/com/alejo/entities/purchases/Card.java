package com.alejo.entities.purchases;

import com.alejo.entities.auth.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "card")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 19)
    private String number;

    @Column(nullable = false, length = 5)
    private String expiration;

    @Column(nullable = false)
    private Integer cvv;

    @Column(nullable = false, length = 100)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usr", nullable = false)
    private User user;
}