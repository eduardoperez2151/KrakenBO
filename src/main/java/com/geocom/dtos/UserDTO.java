package com.geocom.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class UserDTO implements Identifiable<Long> {

	@ApiModelProperty(value = "User identifier")
	private Long id;

	@ApiModelProperty(value = "User name")
	private String name;

	@ApiModelProperty(value = "User email")
	private String email;

	@ApiModelProperty(value = "User password")
	private String password;

	@ApiModelProperty(value = "User is deleted")
	private Boolean deleted;

	@ApiModelProperty(value = "User description")
	private String description;

	@ApiModelProperty(value="User roles")
	private List<RoleDTO> roles;

}
