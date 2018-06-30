package com.geocom.converters;

import com.geocom.dtos.RoleDTO;
import com.geocom.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.geocom.dtos.UserDTO;
import com.geocom.models.User;

import java.util.List;

@Component
@ConfigurationPropertiesBinding
public class UserConverter implements Converter<UserDTO,User> {

	@Lazy
	@Autowired
	private ConversionService conversionService;

	@Nullable
	@Override
	public User convert(final UserDTO userDTO) {
    
		return User.builder()
				.id(userDTO.getId())
				.name(userDTO.getName())
				.email(userDTO.getEmail())
				.deleted(userDTO.getDeleted())
				.description(userDTO.getDescription())
				.roles(getRoles(userDTO.getRoles()))
				.build();
	}

	private List<Role> getRoles(final List<RoleDTO> rolesDTOList) {
		final TypeDescriptor sourceType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(RoleDTO.class));
		final TypeDescriptor targetType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Role.class));
		return (List<Role>) this.conversionService.convert(rolesDTOList, sourceType, targetType);
	}
}
