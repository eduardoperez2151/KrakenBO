package com.geocom.services;

import com.geocom.dtos.UserDTO;

import java.util.List;

public interface UserService extends Service<UserDTO, Long> {

    List<UserDTO> getAllActive();
    void setInactiveUser(final Long id);
    void setActiveUser(final Long id);


}
