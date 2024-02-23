package com.fredd.users_api.application.mapper;

import com.fredd.users_api.domain.model.User;
import com.fredd.users_api.domain.model.dto.UserDto;
import com.fredd.users_api.domain.model.dto.request.UserCreateRequestDto;
import com.fredd.users_api.domain.model.dto.request.UserLoginRequestDto;
import org.mapstruct.Mapper;

@Mapper
public interface UserDtoMapper {

    //for login
    User toDomain(UserLoginRequestDto loginRequestDto);

    //for login
    UserDto toDto(User user);

    //for create user
    User toDomain(UserCreateRequestDto userCreateRequestDto);
}
