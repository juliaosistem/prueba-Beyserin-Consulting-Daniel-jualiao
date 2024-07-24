package com.juliaosystem.infraestructure.services.primary;

import com.juliaosystem.api.dto.response.UserResponse;
import com.juliaosystem.infraestructure.adapters.primary.UserServiceImpl;
import com.juliaosystem.utils.PlantillaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private  final UserServiceImpl userServiceImpl;

    public PlantillaResponse<UserResponse> all(String tipoDocumento, String numeroDocumento) {
        return userServiceImpl.all( tipoDocumento, numeroDocumento);
    }
}
