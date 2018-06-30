package com.geocom.converters;

import com.geocom.dtos.RoleDTO;
import com.geocom.dtos.UserDTO;
import com.geocom.models.Role;
import com.geocom.models.User;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class RoleDTOConverter implements Converter<Role, RoleDTO> {

	@Nullable
	@Override
	public RoleDTO convert(final Role role) {
		return RoleDTO.builder()
				.id(role.getId())
				.name(role.getName())
				.description((role.getDescription()))
				.deleted(role.getDeleted())
				.build();
	}
}
