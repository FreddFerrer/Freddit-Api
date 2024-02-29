package com.fredd.users_api.model.dtos.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginRequestDto {

    @NotNull(message = "username empty")
    private String username;

    @NotNull
    private String password;
}
