package com.geocom.controllers;

import com.geocom.controllers.abstracts.AbstractController;
import com.geocom.dtos.LocalDTO;
import com.geocom.services.LocalService;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/locals", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "GeoCom locals services", produces = "application/json" )
public class LocalController extends AbstractController<LocalDTO,Long> {

    public LocalController(final LocalService localService) {
        super(localService);
    }
}
