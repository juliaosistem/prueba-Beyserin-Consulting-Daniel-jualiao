package com.juliaosystem.infraestructure.repositories;

import com.juliaosystem.api.dto.UserDTO;
import com.juliaosystem.api.dto.request.UserRequest;
import com.juliaosystem.api.dto.response.UserResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {

    public List<UserDTO> findByTipoDocumento(String tipoDocumento,  List<UserDTO> userDTOList ) {
        return userDTOList.stream()
                .filter(user -> user.getIdUser().getTipoDocumento().equals(tipoDocumento)).toList();

    }


    public List<UserDTO> findByNumeroDocumento(String nuumeroDocumento , List<UserDTO> userDTOList) {
        return userDTOList.stream()
                .filter(user -> user.getIdUser().getNumeroDocumento().equals(nuumeroDocumento))
                .toList();

    }


    public List<UserDTO> findAll(){

       var  user1 = UserDTO.builder()
               .datosUser(UserResponse.builder()
                       .ciudadResidencia("Cali")
                       .direccion("carrera 141a # 144 58")
                       .primerNombre("Estiben")
                       .segundoNombre("Miguel")
                       .primerApellido("martinez")
                       .segundoApellido("rodriges")
                       .telefono("3186877468")
                       .build())
               .idUser(UserRequest.builder()
                       .numeroDocumento("23445322")
                       .tipoDocumento("C")
                       .build())
               .build();

       var user2  = UserDTO.builder()
                .datosUser(UserResponse.builder()
                        .ciudadResidencia("Bogota")
                        .direccion("carrera 144a # 144 58")
                        .primerNombre("Daniel")
                        .segundoNombre("Esteban")
                        .primerApellido("Juliao")
                        .segundoApellido("Nova")
                        .telefono("3186877469")
                        .build())
                .idUser(UserRequest.builder()
                        .numeroDocumento("1014267700")
                        .tipoDocumento("C")
                        .build())
                .build();

        var user3  = UserDTO.builder()
                .datosUser(UserResponse.builder()
                        .ciudadResidencia("Bogota")
                        .direccion("carrera 144a # 144 58")
                        .primerNombre("Daniel")
                        .segundoNombre("u")
                        .primerApellido("Juliao")
                        .segundoApellido("Nova")
                        .telefono("3186877469")
                        .build())
                .idUser(UserRequest.builder()
                        .numeroDocumento("1014267701")
                        .tipoDocumento("P")
                        .build())
                .build();
        List<UserDTO> userDTOList  = new ArrayList<>()  ;

        userDTOList.add(user1);
        userDTOList.add(user2);
        userDTOList.add(user3);

        return  userDTOList;
    }
}
