package com.geocom.converters;

import com.geocom.dtos.PermissionDTO;
import com.geocom.dtos.RoleDTO;
import com.geocom.models.Permission;
import com.geocom.models.Role;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class PermissionDTOConverter implements Converter<Permission, PermissionDTO> {

	@Nullable
	@Override
	public PermissionDTO convert(final Permission entity) {
		return PermissionDTO.builder()
				.id(entity.getId())
				.name(entity.getName())
				.description(entity.getDescription())
				.build();
	}
}
