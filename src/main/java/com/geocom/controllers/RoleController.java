package com.geocom.controllers;

import com.geocom.controllers.abstracts.AbstractController;
import com.geocom.dtos.ResponseAPI;
import com.geocom.dtos.RoleDTO;
import com.geocom.dtos.UserDTO;
import com.geocom.services.RoleService;
import com.geocom.services.Service;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/role", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "GeoCom Role services", produces = "application/json")
public class RoleController extends AbstractController<RoleDTO, Long> {

    protected RoleController(final RoleService roleService) {
        super(roleService);
    }

    @Override
    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Delete", notes = "Delete")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    public ResponseEntity<ResponseAPI> delete(
            @ApiParam(name = "id") @PathVariable final Long id) {
        ((RoleService) this.service).setInactiveRole(id);
        final ResponseAPI responseAPI = ResponseAPI.ok();
        return ResponseEntity.ok(responseAPI);
    }


}
