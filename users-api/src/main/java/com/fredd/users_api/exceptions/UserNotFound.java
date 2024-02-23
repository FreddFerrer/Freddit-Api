package com.fredd.users_api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UserNotFound extends RuntimeException{

    private String fieldName;


    public UserNotFound(String fieldName) {
        super(String.format("User with id %s not found", fieldName ));
        this.fieldName = fieldName;
    }
}
