package com.geocom.dtos;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PermissionDTO implements Identifiable<Long> {

    @ApiModelProperty(value = "Permission identifier")
    private Long id;

    @ApiModelProperty(value = "Permission name")
    private String name;

    @ApiModelProperty(value = "Permission description")
    private String description;

}
