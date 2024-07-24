package com.juliaosystem.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.juliaosystem.api.dto.request.UserRequest;
import com.juliaosystem.api.dto.response.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDTO {

    @JsonProperty("datosUser")
    private UserResponse datosUser;

    @JsonProperty("idUser")
    private   UserRequest idUser;

}
