package com.fredd.users_api.application.usecases;

import com.fredd.users_api.domain.model.dto.UserDto;
import com.fredd.users_api.domain.model.dto.request.UserCreateRequestDto;

import java.util.List;

public interface UserService {

    UserDto createNewUser(UserCreateRequestDto request);
    UserDto getById(Long id);
    List<UserDto> getAll();
    void deleteById(Long id);
    UserDto update(UserCreateRequestDto request, Long id);
}
