package com.fredd.users_api.domain.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserCreateRequestDto {
    private String username;
    private String password;
    private byte age;
    private String email;
    private Integer phoneNumber;
}
