package com.geocom.services.implementation;

import com.geocom.dtos.RoleDTO;
import com.geocom.models.Role;
import com.geocom.repositories.RoleRepository;
import com.geocom.services.RoleService;
import com.geocom.services.abstracts.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends AbstractService<RoleDTO,Role,Long> implements RoleService {

    @Autowired
    public RoleServiceImpl(RoleRepository repository, ConversionService conversionService) {
        super(repository, conversionService, RoleDTO.class, Role.class);
    }

    @Override
    public void setInactiveRole(Long id) {
        this.findEntity(id);
        ((RoleRepository)this.repository).delete(id);
    }
}
