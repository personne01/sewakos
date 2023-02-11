package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {
    private String name;
    private String email;
    private String nik;
    private String gender;
    private String phone;
    private String username;
    private Long rolesId;
    private String password;
}
