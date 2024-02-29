package com.fredd.users_api.model.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponseDto {
    private String token;
    private final String type = "Bearer";
    private Long id;
    private String username;
    private String email;
    private String role;
}
