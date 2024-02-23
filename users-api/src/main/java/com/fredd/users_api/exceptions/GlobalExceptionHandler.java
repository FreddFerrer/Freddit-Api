package com.fredd.users_api.exceptions;

import com.fredd.users_api.payload.CustomErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //controla los errores de los campos
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handlderMethodArgumentNotValidException(MethodArgumentNotValidException exception,
                                                                          WebRequest webRequest) {
        Map<String, String> mapErrors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
                    String clave = ((FieldError) error).getField();
                    String valor = error.getDefaultMessage();
                    mapErrors.put(clave, valor);
                }
        );
        CustomErrorMessage apiResponse = new CustomErrorMessage(webRequest.getDescription(false), mapErrors);
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }

    //usuario no encontrado
    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<CustomErrorMessage> handleUsuarioNoEncontrado(UserNotFound ex) {
        CustomErrorMessage apiResponse = new CustomErrorMessage(ex.getMessage(), "User Not Found");
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }
}
