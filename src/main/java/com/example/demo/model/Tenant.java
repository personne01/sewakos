package com.example.demo.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String nik;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false, unique = true)
    private String phone;

    @OneToOne(mappedBy = "tenant", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private User user;
}