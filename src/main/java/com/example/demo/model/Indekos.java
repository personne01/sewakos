package com.example.demo.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Indekos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String detail;
    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String cost;

    @Column(nullable = false)
    private String location;

    @ManyToOne
    private User user;
}
