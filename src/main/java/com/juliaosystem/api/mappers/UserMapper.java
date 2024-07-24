package com.juliaosystem.api.mappers;

import com.juliaosystem.api.dto.UserDTO;
import com.juliaosystem.api.dto.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel ="spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper {


    @Mapping(source = "datosUser.primerNombre", target = "primerNombre")
    @Mapping(source = "datosUser.segundoNombre", target = "segundoNombre")
    @Mapping(source = "datosUser.primerApellido", target = "primerApellido")
    @Mapping(source = "datosUser.segundoApellido", target = "segundoApellido")
    @Mapping(source = "datosUser.telefono", target = "telefono")
    @Mapping(source = "datosUser.direccion", target = "direccion")
    @Mapping(source = "datosUser.ciudadResidencia", target = "ciudadResidencia")
    UserResponse toResponse(UserDTO userDTO);

    List<UserResponse> toResponse(List<UserDTO> all);
}
