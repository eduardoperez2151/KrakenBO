package com.geocom.services.implementation;

import com.geocom.dtos.UserDTO;
import com.geocom.models.User;
import com.geocom.repositories.UserRepository;
import com.geocom.services.UserService;
import com.geocom.services.abstracts.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl extends AbstractService<UserDTO,User,Long> implements UserService {

    @Autowired
    public UserServiceImpl(final UserRepository repository, final ConversionService conversionService) {
        super(repository, conversionService, UserDTO.class, User.class);
    }

    @Override
    public List<UserDTO> getAllActive() {
        final TypeDescriptor sourceType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(User.class));
        final TypeDescriptor targetType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(UserDTO.class));
        final List<User> users = ((UserRepository)this.repository).findByDeletedFalse();
        return (List<UserDTO>) this.conversionService.convert(users, sourceType, targetType);
    }

    @Override
    public void setInactiveUser(final Long id) {
        this.findEntity(id);
        ((UserRepository)this.repository).delete(id);
    }

    @Override
    public void setActiveUser(Long id) {
        this.findEntity(id);
        ((UserRepository)this.repository).activateUser(id);
    }
}
