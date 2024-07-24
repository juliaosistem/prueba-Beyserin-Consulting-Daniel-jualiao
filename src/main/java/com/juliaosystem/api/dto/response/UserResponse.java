package com.juliaosystem.api.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserResponse {

    @JsonProperty("primerNombre")
    private String primerNombre;

    @JsonProperty("segundoNombre")
    private String segundoNombre;

    @JsonProperty("primerApellido")
    private String primerApellido;

    @JsonProperty("segundoApellido")
    private String segundoApellido;

    @JsonProperty("telefono")
    private String telefono;

    @JsonProperty("direccion")
    private String direccion;

    @JsonProperty("ciudadResidencia")
    private String ciudadResidencia;
}
