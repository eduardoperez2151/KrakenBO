package com.geocom.models;

import com.geocom.models.abstracts.AbstractDescribableEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "locals")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Local extends AbstractDescribableEntity<Long> {

    private Long commune;
    private Boolean deleted;
    private String rut;
    private String city;
    private String phone;
    private String address;
    private String subclass;
    private String localType;
    private String companyName;
    private String localConfigurationId;

    @ManyToMany
    @JoinTable(name = "locals_users", joinColumns = {
            @JoinColumn(name = "local_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "id")})
    private List<User> users;

    @Builder
    public Local(final Long id, final String name, final String description, final Long commune,
                 final Boolean deleted,
                 final String rut, final String city, final String phone, final String address, final String subclass,
                 final String localType, final String companyName, final String localConfigurationId,
                 final List<User> users) {
        super(name, description);
        this.id = id;
        this.rut = rut;
        this.city = city;
        this.phone = phone;
        this.users = users;
        this.commune = commune;
        this.address = address;
        this.deleted = deleted;
        this.subclass = subclass;
        this.localType = localType;
        this.companyName = companyName;
        this.localConfigurationId = localConfigurationId;
    }
}
