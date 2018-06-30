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
public class RoleDTO implements Identifiable<Long> {

    @ApiModelProperty(value = "Role identifier")
    private Long id;

    @ApiModelProperty(value = "Role name")
    private String name;

    @ApiModelProperty(value = "Role description")
    private String description;

    @ApiModelProperty(value = "Role is deleted")
    private Boolean deleted;

    @ApiModelProperty(value = "Role permissions")
    private List<PermissionDTO> permissions;

    public RoleDTO(final Long id) {
        this.id = id;
    }

}
