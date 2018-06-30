package com.geocom.services.implementation;

import com.geocom.dtos.PermissionDTO;
import com.geocom.models.Permission;
import com.geocom.repositories.PermissionRepository;
import com.geocom.services.PermissionService;
import com.geocom.services.abstracts.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl extends AbstractService<PermissionDTO,Permission,Long> implements PermissionService {

    @Autowired
    public PermissionServiceImpl(PermissionRepository repository, ConversionService conversionService) {
        super(repository, conversionService, PermissionDTO.class, Permission.class);
    }
}
