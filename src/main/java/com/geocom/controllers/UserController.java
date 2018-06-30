package com.geocom.controllers;

import java.util.List;

import com.geocom.controllers.abstracts.AbstractController;
import com.geocom.services.Service;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geocom.dtos.ResponseAPI;
import com.geocom.dtos.UserDTO;
import com.geocom.services.UserService;

@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "GeoCom User services", produces = "application/json")
public class UserController extends AbstractController<UserDTO, Long> {


    protected UserController(final UserService userService) {
        super(userService);
    }

    @GetMapping(path = "/active")
    @ApiOperation(value = "Get all", notes = "Get all")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    public ResponseEntity<ResponseAPI> getAllActive() {
        final List<UserDTO> users = ((UserService) this.service).getAllActive();
        final ResponseAPI responseAPI = ResponseAPI.ok(users);
        return ResponseEntity.ok(responseAPI);
    }

    @Override
    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Delete", notes = "Delete")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    public ResponseEntity<ResponseAPI> delete(
            @ApiParam(name = "id") @PathVariable final Long id) {
        ((UserService) this.service).setInactiveUser(id);
        final ResponseAPI responseAPI = ResponseAPI.ok();
        return ResponseEntity.ok(responseAPI);
    }

    @PatchMapping(path = "/{id}/activate")
    @ApiOperation(value = "Activate an User", notes = "Activate an User")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    public ResponseEntity<ResponseAPI> activate(
            @ApiParam(name = "id") @PathVariable final Long id) {
        ((UserService) this.service).setActiveUser(id);
        final ResponseAPI responseAPI = ResponseAPI.ok();
        return ResponseEntity.ok(responseAPI);
    }


}
