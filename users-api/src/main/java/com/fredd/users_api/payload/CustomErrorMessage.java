package com.fredd.users_api.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class CustomErrorMessage {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String estado;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map<String, String> errors;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String mensaje;

    public CustomErrorMessage(String estado, String mensaje) {
        this.estado = estado;
        this.mensaje = mensaje;
    }

    public CustomErrorMessage(String mensaje, Map<String, String> errors) {
        this.mensaje = mensaje;
        this.errors = errors;
    }

    public CustomErrorMessage(String estado) {
        this.estado = estado;
    }
}
