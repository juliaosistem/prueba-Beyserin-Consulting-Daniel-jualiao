package com.juliaosystem.api.controller;


import com.juliaosystem.api.dto.response.UserResponse;
import com.juliaosystem.infraestructure.services.primary.UserService;
import com.juliaosystem.utils.PlantillaResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
@AutoConfigureMockMvc(addFilters = false)
@ImportAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
class UserControllerTest {

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testAllUsers() throws Exception {
        UserResponse userResponse = new UserResponse();
        PlantillaResponse<UserResponse> mockResponse = PlantillaResponse.<UserResponse>builder()
                .httpStatus(HttpStatus.OK)
                .data(Collections.singletonList(userResponse).getFirst())
                .dataList(Collections.singletonList(userResponse))
                .build();

        when(userService.all(anyString(), anyString())).thenReturn(mockResponse);

        mockMvc.perform(get("/user/all")
                        .param("tipoDocumento", "P")
                        .param("numeroDocumento", "12345678")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();

        verify(userService).all(anyString(), anyString());
    }
}
