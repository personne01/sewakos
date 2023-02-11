package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    private Boolean isAccountLocked;
    private Boolean isEnabled;

//
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

//    User berelasi dengan tenant untuk mendapatkan datanya tenant/penyewa
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Biodata biodata;

}
