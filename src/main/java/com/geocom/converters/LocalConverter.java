package com.geocom.converters;

import com.geocom.dtos.LocalDTO;
import com.geocom.dtos.PermissionDTO;
import com.geocom.dtos.UserDTO;
import com.geocom.models.Local;
import com.geocom.models.Permission;
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
public class LocalConverter implements Converter<LocalDTO,Local> {

	@Lazy
	@Autowired
	private ConversionService conversionService;

	@Nullable
	@Override
	public Local convert(final LocalDTO dto) {
		return Local.builder()
				.id(dto.getId())
				.name(dto.getName())
				.description(dto.getDescription())
				.deleted(dto.getDeleted())
				.address(dto.getAddress())
				.city(dto.getCity())
				.commune(dto.getCommune())
				.companyName(dto.getCompanyName())
				.localType(dto.getLocalType())
				.phone(dto.getPhone())
				.rut(dto.getRut())
				.subclass(dto.getSubclass())
				.localConfigurationId(dto.getLocalConfigurationId())
				.users(getUsers(dto.getUsers()))
				.build();
	}

	private List<User> getUsers(final List<UserDTO> users) {
		final TypeDescriptor sourceType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(UserDTO.class));
		final TypeDescriptor targetType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(User.class));
		return (List<User>) this.conversionService.convert(users, sourceType, targetType);

	}
}
