package com.fredd.users_api.auth;

import com.fredd.users_api.jwt.JwtService;
import com.fredd.users_api.model.dtos.LoginResponseDto;
import com.fredd.users_api.model.dtos.request.CreateUserDto;
import com.fredd.users_api.model.dtos.request.LoginRequestDto;
import com.fredd.users_api.model.entities.User;
import com.fredd.users_api.model.enums.RolEnum;
import com.fredd.users_api.model.repository.IUserRepository;
import jakarta.ws.rs.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final IUserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public LoginResponseDto login(LoginRequestDto request) {
        var authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token=jwtService.getToken(user);
        return LoginResponseDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole().name())
                .token(token)
                .build();
    }

    public LoginResponseDto register(CreateUserDto request) {

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new BadRequestException("Username already exists");
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new BadRequestException("Email already exists");
        }

        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode( request.getPassword()))
                .email(request.getEmail())
                .name(request.getName())
                .surname(request.getSurname())
                .role(RolEnum.ROLE_USUARIO)
                .build();

        userRepository.save(user);

        return LoginResponseDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole().name())
                .build();
    }
}
