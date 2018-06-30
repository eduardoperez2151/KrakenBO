
package com.geocom.controllers;

import com.geocom.controllers.abstracts.AbstractControllerTest;
import com.geocom.dtos.ResponseAPI;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class UserControllerTest extends AbstractControllerTest {

    @Test
    public void getAllUsers() throws Exception {
        checkRestAPIResponse(get("/user"), null, status().isOk(), ResponseAPI.SUCCESS_CODE, ResponseAPI.SUCCESS_MESSAGE)
                .andExpect(jsonPath("$.data", hasSize(3)))
                .andExpect(jsonPath("$.data[0].id", is(24)))
                .andExpect(jsonPath("$.data[0].name", equalTo("Eduardo")))
                .andExpect(jsonPath("$.data[0].deleted", is(false)));
    }

    @Test
    public void createUserOK() throws Exception {
        final String createUserJSON = getFile("classpath:request/user/createOK.json");
        checkRestAPIResponse(post("/user"), createUserJSON, status().isOk(), ResponseAPI.SUCCESS_CODE, ResponseAPI.SUCCESS_MESSAGE)
                .andExpect(jsonPath("$.data.name", equalTo("Juan Pedro")))
                .andExpect(jsonPath("$.data.deleted", is(false)));
    }

    @Test
    public void createUserAlreadyExists() throws Exception {
        final String createUserJSON = getFile("classpath:request/user/createExists.json");
        checkRestAPIResponse(post("/user"), createUserJSON, status().isConflict(), ResponseAPI.ERROR_CODE, "La entidad con id 24 ya existe");
    }

    @Test
    public void createUserWithIdAndNotExist() throws Exception {
        final String createUserJSON = getFile("classpath:request/user/createWithIdAndNotExists.json");
        checkRestAPIResponse(post("/user"), createUserJSON, status().isOk(), ResponseAPI.SUCCESS_CODE, ResponseAPI.SUCCESS_MESSAGE);
    }


    @Test
    public void deleteUserOK() throws Exception {
        checkRestAPIResponse(get("/user"), null, status().isOk(), ResponseAPI.SUCCESS_CODE, ResponseAPI.SUCCESS_MESSAGE)
                .andExpect(jsonPath("$.data", hasSize(3)));

        checkRestAPIResponse(delete("/user/24"), null, status().isOk(), ResponseAPI.SUCCESS_CODE, ResponseAPI.SUCCESS_MESSAGE);

        checkRestAPIResponse(get("/user"), null, status().isOk(), ResponseAPI.SUCCESS_CODE, ResponseAPI.SUCCESS_MESSAGE)
                .andExpect(jsonPath("$.data", hasSize(2)));
    }

    @Test
    public void deleteUserNotExists() throws Exception {
        checkRestAPIResponse(get("/user"), null, status().isOk(), ResponseAPI.SUCCESS_CODE, ResponseAPI.SUCCESS_MESSAGE)
                .andExpect(jsonPath("$.data", hasSize(3)));

        checkRestAPIResponse(delete("/user/4"), null, status().isNotFound(), ResponseAPI.ERROR_CODE, "La entidad con id 4 no existe");

        checkRestAPIResponse(get("/user"), null, status().isOk(), ResponseAPI.SUCCESS_CODE, ResponseAPI.SUCCESS_MESSAGE)
                .andExpect(jsonPath("$.data", hasSize(3)));
    }

    @Test
    public void deleteUserTwice() throws Exception {
        checkRestAPIResponse(get("/user"), null, status().isOk(), ResponseAPI.SUCCESS_CODE, ResponseAPI.SUCCESS_MESSAGE)
                .andExpect(jsonPath("$.data", hasSize(3)));

        checkRestAPIResponse(delete("/user/24"), null, status().isOk(), ResponseAPI.SUCCESS_CODE, ResponseAPI.SUCCESS_MESSAGE);

        checkRestAPIResponse(get("/user"), null, status().isOk(), ResponseAPI.SUCCESS_CODE, ResponseAPI.SUCCESS_MESSAGE)
                .andExpect(jsonPath("$.data", hasSize(2)));

        checkRestAPIResponse(delete("/user/24"), null, status().isNotFound(), ResponseAPI.ERROR_CODE, "La entidad con id 24 no existe");

        checkRestAPIResponse(get("/user"), null, status().isOk(), ResponseAPI.SUCCESS_CODE, ResponseAPI.SUCCESS_MESSAGE)
                .andExpect(jsonPath("$.data", hasSize(2)));
    }

    @Test
    public void getUserByIdOK() throws Exception {
        checkRestAPIResponse(get("/user/24"), null, status().isOk(), ResponseAPI.SUCCESS_CODE, ResponseAPI.SUCCESS_MESSAGE)
                .andExpect(jsonPath("$.data.name", equalTo("Eduardo")))
                .andExpect(jsonPath("$.data.email", equalTo("ed@mail.com")))
                .andExpect(jsonPath("$.data.deleted", is(false)))
                .andExpect(jsonPath("$.data.description", equalTo("user Test 1")));
    }

    @Test
    public void getUserByIdNotExists() throws Exception {
        checkRestAPIResponse(get("/user/100"), null, status().isNotFound(), ResponseAPI.ERROR_CODE, "La entidad con id 100 no existe");
    }

    @Test
    public void updateUserOK() throws Exception {
        checkRestAPIResponse(get("/user/24"), null, status().isOk(), ResponseAPI.SUCCESS_CODE, ResponseAPI.SUCCESS_MESSAGE)
                .andExpect(jsonPath("$.data.name", equalTo("Eduardo")))
                .andExpect(jsonPath("$.data.email", equalTo("ed@mail.com")))
                .andExpect(jsonPath("$.data.deleted", is(false)))
                .andExpect(jsonPath("$.data.description", equalTo("user Test 1")));

        final String updateUserJSON = getFile("classpath:request/user/updateOK.json");

        checkRestAPIResponse(patch("/user"), updateUserJSON, status().isOk(), ResponseAPI.SUCCESS_CODE, ResponseAPI.SUCCESS_MESSAGE);

        checkRestAPIResponse(get("/user/24"), null, status().isOk(), ResponseAPI.SUCCESS_CODE, ResponseAPI.SUCCESS_MESSAGE)
                .andExpect(jsonPath("$.data.name", equalTo("Juan Jose Damiani")))
                .andExpect(jsonPath("$.data.email", equalTo("JuanJose@live.com")))
                .andExpect(jsonPath("$.data.deleted", is(false)))
                .andExpect(jsonPath("$.data.description", equalTo("Juan Jose Developer")));
    }

    @Test
    public void updateNotExist() throws  Exception{
        final String updateUserJSON = getFile("classpath:request/user/updateNotExists.json");
        checkRestAPIResponse(patch("/user"), updateUserJSON, status().isNotFound(), ResponseAPI.ERROR_CODE,"La entidad con id 4 no existe" );
    }
}
