package com.geocom.services;

import com.geocom.dtos.RoleDTO;

public interface RoleService extends Service<RoleDTO, Long> {

    void setInactiveRole(Long id);
}
