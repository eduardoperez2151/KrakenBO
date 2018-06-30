package com.geocom.converters;

import com.geocom.dtos.RoleDTO;
import com.geocom.dtos.UserDTO;
import com.geocom.models.Role;
import com.geocom.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationPropertiesBinding
public class UserDTOConverter implements Converter<User, UserDTO> {

    @Lazy
    @Autowired
    private ConversionService conversionService;


    @Nullable
    @Override
    public UserDTO convert(final User user) {

        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .deleted(user.getDeleted())
                .description(user.getDescription())
                .roles(getRoles(user.getRoles()))
                .build();

    }

    private List<RoleDTO> getRoles(List<Role> roles) {
        final TypeDescriptor targetType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(RoleDTO.class));
        final TypeDescriptor sourceType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Role.class));
        return (List<RoleDTO>) this.conversionService.convert(roles, sourceType, targetType);
    }


}
