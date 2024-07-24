package com.juliaosystem.infraestructure.adapters.primary;

import com.juliaosystem.api.dto.UserDTO;
import com.juliaosystem.api.dto.response.UserResponse;
import com.juliaosystem.infraestructure.services.secondary.UserServiceInter;
import com.juliaosystem.utils.PlantillaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl {
    private final UserServiceInter userServiceInter;

    public PlantillaResponse<UserResponse> all(String tipoDocumento, String numeroDocumento) {
        PlantillaResponse<UserResponse> res =  null;
        List<UserDTO > userDTOList;

             if (numeroDocumento == null  &&  tipoDocumento == null)
               return   userServiceInter.all();
              else
               userDTOList = new ArrayList<>(userServiceInter.allUserDTO());

              if(tipoDocumento != null )
                  res = userServiceInter.byTipoDocumento(tipoDocumento ,userDTOList);

             if (numeroDocumento != null )
                 res= userServiceInter.byNumeroDocumento(numeroDocumento, userDTOList);

             return res;
     }
    }



