package com.fredd.users_api.application.service;

import com.fredd.users_api.application.mapper.UserDtoMapper;
import com.fredd.users_api.application.usecases.UserService;
import com.fredd.users_api.domain.model.constant.UserConstant;
import com.fredd.users_api.domain.model.dto.UserDto;
import com.fredd.users_api.domain.model.dto.request.UserCreateRequestDto;
import com.fredd.users_api.domain.port.UserPersistancePort;
import jdk.jshell.spi.ExecutionControl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserManagmentService implements UserService {

    private final UserPersistancePort userPersistencePort;
    private final UserDtoMapper userDtoMapper;


    @Override
    public UserDto createNewUser(UserCreateRequestDto request) {
        var userRequest = userDtoMapper.toDomain(request);
        var userCreated = userPersistencePort.create(userRequest);
        return userDtoMapper.toDto(userCreated);
    }

    @Override
    public UserDto getById(Long id) {
        var user = userPersistencePort.getById(id);
        return userDtoMapper.toDto(user);
    }

    @Override
    public List<UserDto> getAll() {
        var users = userPersistencePort.getAll();
        return users
                .stream()
                .map(userDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        var user = userPersistencePort.getById(id);

        userPersistencePort.deleteById(id);
    }

    @Override
    public UserDto update(UserCreateRequestDto request, Long id) {
        return null;
    }
}
