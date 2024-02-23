package com.fredd.users_api.model.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

@Data
public class CreateUserDto {

    @NotEmpty(message = "campo username obligatorio")
    @NotNull
    @UniqueElements
    private String username;

    @NotEmpty(message = "username required")
    @NotNull
    private String password;

    @Email
    @NotEmpty(message = "email required")
    @NotNull
    private String email;

    @NotEmpty(message = "name required")
    @NotNull
    private String name;

    @NotEmpty(message = "surname required")
    @NotNull
    private String surname;

    @NotEmpty(message = "country required")
    @NotNull
    private String country;

    @NotEmpty(message = "city required")
    @NotNull
    private String city;
}
