package com.fredd.users_api.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    private Long id;
    private String username;
    private String password;
    private byte age;
    private String email;
    private Integer phoneNumber;
    private UserRole role;

}
