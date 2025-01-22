package com.juliaosystem.infraestructure.adapters.secondary;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.juliaosystem.api.dto.UserDTO;
import com.juliaosystem.api.dto.response.UserResponse;
import com.juliaosystem.api.mappers.UserMapper;
import com.juliaosystem.infraestructure.repositories.UserRepository;
import com.juliaosystem.infraestructure.services.secondary.UserServiceInter;
import com.juliaosystem.utils.AbtractError;
import com.juliaosystem.utils.PlantillaResponse;
import com.juliaosystem.utils.UserResponses;
import com.juliaosystem.utils.enums.MensajesRespuesta;
import com.juliaosystem.utils.enums.ResponseType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserAdapter implements UserServiceInter {

    private static final ObjectMapper OBJECT_MAPPER =
            new ObjectMapper().registerModule(new JavaTimeModule());
    private final AbtractError abtractError;
    private  final UserRepository userRepository;
    private  final UserMapper mapper;
    private final UserResponses<UserResponse> userResponses;

    @Override
    public PlantillaResponse<UserResponse> all() {
        try {
            var userReponse  =  mapper.toResponse(userRepository.findAll());
            abtractError.logInfo("userAdapter.all():" + MensajesRespuesta.GET.getMensaje() +" de usuarios" +  OBJECT_MAPPER.writeValueAsString(userReponse));
            return userResponses.buildResponse(ResponseType.GET.getCode(), UserResponse.builder().build(),  userReponse);
        }catch (Exception e){
            abtractError.logError(e);
            return userResponses.buildResponse(ResponseType.FALLO.getCode() , UserResponse.builder().build());
        }
    }

    @Override
    public PlantillaResponse<UserResponse> byTipoDocumento(String tipoDocumento, List<UserDTO> userDTOList) {
        try {
            var userReponse  =  mapper.toResponse(userRepository.findByTipoDocumento(tipoDocumento,userDTOList));
            if (!userReponse.isEmpty()) {
                abtractError.logInfo("userAdapter.byTipoDocumento():" + MensajesRespuesta.GET.getMensaje() + " de usuarios" + OBJECT_MAPPER.writeValueAsString(userReponse));
                return userResponses.buildResponse(ResponseType.GET.getCode(), UserResponse.builder().build(), userReponse);
            }else {
                abtractError.logInfo("userAdapter.byTipoDocumento():" + MensajesRespuesta.NO_ENCONTRADO.getMensaje() + "de usuarios ---"+ OBJECT_MAPPER.writeValueAsString(userReponse));
                return userResponses.buildResponse(ResponseType.NO_ENCONTRADO.getCode(), UserResponse.builder().build() , Collections.emptyList());
            }
        }catch (Exception e){
            abtractError.logError(e);
            return userResponses.buildResponse(ResponseType.FALLO.getCode() , UserResponse.builder().build() ,Collections.emptyList());
        }
    }

    @Override
    public PlantillaResponse<UserResponse> byNumeroDocumento(String numeroDocumento, List<UserDTO> userDTOList) {
        try {
             var users =userRepository.findByNumeroDocumento(numeroDocumento,userDTOList);
             if(!users.isEmpty()) {
                 var userReponse = mapper.toResponse(users);
                 abtractError.logInfo("userAdapter.byNumeroDocumento():" + MensajesRespuesta.GET.getMensaje() + "de usuarios" + OBJECT_MAPPER.writeValueAsString(userReponse));
                 return userResponses.buildResponse(ResponseType.GET.getCode(), UserResponse.builder().build(), userReponse);
             }else {
                 abtractError.logInfo("userAdapter.byNumeroDocumento():" + MensajesRespuesta.NO_ENCONTRADO.getMensaje()+ "de usuarios" + OBJECT_MAPPER.writeValueAsString(users));
                 return userResponses.buildResponse(ResponseType.NO_ENCONTRADO.getCode(), UserResponse.builder().build());
             }
        }catch (Exception e){
            abtractError.logError(e);
            return userResponses.buildResponse(ResponseType.FALLO.getCode() , UserResponse.builder().build());
        }
    }

    @Override
    public List<UserDTO> allUserDTO() {
        return userRepository.findAll();
    }


}
