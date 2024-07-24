package com.juliaosystem.api.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserRequest {



        @NotBlank(message = "El tipo de documento es obligatorio")
        @JsonProperty("tipoDocumento")
        private String tipoDocumento;


        @NotBlank(message = "El número de documento es obligatorio")
        @Size(min = 8, max = 11, message = "El número de documento debe tener entre 8 y 11 caracteres")
        @Pattern(regexp = "\\d+", message = "El número de documento debe contener solo números")
        @JsonProperty("numeroDocumento")
        private String numeroDocumento;


}