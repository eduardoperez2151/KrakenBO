package com.geocom.converters;

import com.geocom.dtos.LocalDTO;
import com.geocom.dtos.UserDTO;
import com.geocom.models.Local;
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
public class LocalDTOConverter implements Converter<Local,LocalDTO> {

	@Lazy
	@Autowired
	private ConversionService conversionService;

	@Nullable
	@Override
	public LocalDTO convert(final Local local) {
		return LocalDTO.builder()
				.id(local.getId())
				.name(local.getName())
				.description(local.getDescription())
				.deleted(local.getDeleted())
				.address(local.getAddress())
				.city(local.getCity())
				.commune(local.getCommune())
				.companyName(local.getCompanyName())
				.localType(local.getLocalType())
				.phone(local.getPhone())
				.rut(local.getRut())
				.subclass(local.getSubclass())
				.localConfigurationId(local.getLocalConfigurationId())
				.users(getUsers(local.getUsers()))
				.build();
	}

	private List<UserDTO> getUsers(final List<User> users) {
		final TypeDescriptor sourceType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(User.class));
		final TypeDescriptor targetType  = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(UserDTO.class));
		return (List<UserDTO>) this.conversionService.convert(users, sourceType, targetType);

	}
}
