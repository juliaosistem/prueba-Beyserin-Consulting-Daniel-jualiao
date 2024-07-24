package com.juliaosystem.api.controller;


import com.juliaosystem.api.dto.response.UserResponse;
import com.juliaosystem.infraestructure.services.primary.UserService;
import com.juliaosystem.utils.PlantillaResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public  class UserController{


    private  final UserService userService;

    @Operation(summary = "all users", description = "permite obtener lista de usuarios con filtros por tipo de documento y numero de documento ")
    @GetMapping("/all")
    public ResponseEntity<PlantillaResponse<UserResponse>> all(
            @RequestParam(value = "tipoDocumento", required = false) String tipoDocumento,
            @RequestParam(value = "numeroDocumento", required = false) String numeroDocumento) {

         var response = userService.all(tipoDocumento, numeroDocumento);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }
}