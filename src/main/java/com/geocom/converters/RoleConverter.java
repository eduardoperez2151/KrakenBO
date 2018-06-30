package com.geocom.converters;

import com.geocom.dtos.PermissionDTO;
import com.geocom.dtos.RoleDTO;
import com.geocom.dtos.UserDTO;
import com.geocom.models.Permission;
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
public class RoleConverter implements Converter<RoleDTO,Role> {

	@Lazy
	@Autowired
	private ConversionService conversionService;

	@Nullable
	@Override
	public Role convert(final RoleDTO dto) {
		return Role.builder()
				.id(dto.getId())
				.name(dto.getName())
				.description(dto.getDescription())
				.deleted(dto.getDeleted())
				.permissions(getPermission(dto.getPermissions()))
				.build();
	}

	private List<Permission> getPermission(final List<PermissionDTO> permissions) {
		final TypeDescriptor sourceType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(PermissionDTO.class));
		final TypeDescriptor targetType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Permission.class));
		return (List<Permission>) this.conversionService.convert(permissions, sourceType, targetType);
	}
}
