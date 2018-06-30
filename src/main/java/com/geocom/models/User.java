package com.geocom.models;

import java.util.List;

import javax.persistence.*;

import com.geocom.models.abstracts.AbstractDescribableEntity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class User extends AbstractDescribableEntity<Long> {

    private static final long serialVersionUID = -4253525184576572516L;

    private String email;
    private String password;
    private Boolean deleted;

    @ManyToMany
    @JoinTable(name = "users_roles", joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;

    @Builder
    public User(final Long id, final String email, final String name, final String description, final String password,
                final Boolean deleted, final List<Role> roles) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.description = description;
        this.password = password;
        this.deleted = deleted;
        this.roles = roles;
    }

}
