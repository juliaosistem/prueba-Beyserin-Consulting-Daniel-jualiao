package com.juliaosystem.infraestructure.services.secondary;

import com.juliaosystem.api.dto.UserDTO;
import com.juliaosystem.api.dto.response.UserResponse;
import com.juliaosystem.utils.PlantillaResponse;

import java.util.List;

public interface UserServiceInter {

    PlantillaResponse<UserResponse> all();

    PlantillaResponse<UserResponse> byTipoDocumento(String tipoDocumento, List<UserDTO> userDTOList);

    PlantillaResponse<UserResponse> byNumeroDocumento(String numeroDocumento, List<UserDTO> userDTOList);

    List<UserDTO> allUserDTO();
}
