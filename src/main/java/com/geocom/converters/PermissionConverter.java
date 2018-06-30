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
public class PermissionConverter implements Converter<PermissionDTO,Permission> {

	@Nullable
	@Override
	public Permission convert(final PermissionDTO dto) {
		return Permission.builder()
				.id(dto.getId())
				.name(dto.getName())
				.description(dto.getDescription())
				.build();
	}
}
