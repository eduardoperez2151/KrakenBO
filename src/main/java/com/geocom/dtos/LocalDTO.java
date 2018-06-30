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
@ApiModel
@NoArgsConstructor
@AllArgsConstructor
public class LocalDTO implements Identifiable<Long> {

    @ApiModelProperty(value = "Local identifier")
    private Long id;

    @ApiModelProperty(value = "Local name")
    private String name;

    @ApiModelProperty(value = "Local description")
    private String description;

    @ApiModelProperty(value = "Commune")
    private Long commune;

    @ApiModelProperty(value = "Local is deleted")
    private Boolean deleted;

    @ApiModelProperty(value = "Local rut")
    private String rut;

    @ApiModelProperty(value = "Local city")
    private String city;

    @ApiModelProperty(value = "Local phone")
    private String phone;

    @ApiModelProperty(value = "Local address")
    private String address;

    @ApiModelProperty(value = "Local subclass")
    private String subclass;

    @ApiModelProperty(value = "Local type")
    private String localType;

    @ApiModelProperty(value = "Local Company name")
    private String companyName;

    @ApiModelProperty(value = "Local configuration id")
    private String localConfigurationId;

    @ApiModelProperty(value = "Local users")
    private List<UserDTO> users;

}
