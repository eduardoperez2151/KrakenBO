package com.geocom.controllers.abstracts;

import com.geocom.dtos.Identifiable;
import com.geocom.dtos.ResponseAPI;
import com.geocom.services.Service;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class AbstractController<D extends Identifiable<K>, K> {

    protected final Service<D, K> service;

    protected AbstractController(final Service<D, K> service) {
        this.service = service;
    }

    @ApiOperation(value = "Get by Id", notes = "Get by Id ")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    @GetMapping(path = "/{id}")
    public ResponseEntity<ResponseAPI> getById(
            @ApiParam(name = "id") @PathVariable final K id) {
        final D dto = this.service.get(id);
        final ResponseAPI responseAPI = ResponseAPI.ok(dto);
        return ResponseEntity.ok(responseAPI);
    }

    @ApiOperation(value = "Get all", notes = "Get all")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    @GetMapping
    public ResponseEntity<ResponseAPI> getAll() {
        final List<D> dtoList = this.service.getAll();
        final ResponseAPI responseAPI = ResponseAPI.ok(dtoList);
        return ResponseEntity.ok(responseAPI);
    }

    @ApiOperation(value = "Create", notes = "Create")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    @PostMapping
    public ResponseEntity<ResponseAPI> create(
            @ApiParam(name = "dto") @RequestBody final D dto) {
        final D newDTO = this.service.create(dto);
        final ResponseAPI responseAPI = ResponseAPI.ok(newDTO);
        return ResponseEntity.ok(responseAPI);
    }

    @ApiOperation(value = "Delete", notes = "Delete")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ResponseAPI> delete(
            @ApiParam(name = "id") @PathVariable final K id) {
        this.service.delete(id);
        final ResponseAPI responseAPI = ResponseAPI.ok();
        return ResponseEntity.ok(responseAPI);
    }

    @ApiOperation(value = "Update", notes = "Update")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    @PatchMapping
    public ResponseEntity<ResponseAPI> update(
            @ApiParam(name = "dto") @RequestBody final D dto) {
        final D newDTO = this.service.update(dto);
        final ResponseAPI responseAPI = ResponseAPI.ok(newDTO);
        return ResponseEntity.ok(responseAPI);
    }
}
