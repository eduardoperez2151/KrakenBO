package com.geocom.models;

import javax.persistence.*;

import com.geocom.models.abstracts.AbstractDescribableEntity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "roles")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Role extends AbstractDescribableEntity<Long> {

	private static final long serialVersionUID = 2221155940003923277L;

	private Boolean deleted;

	@ManyToMany
	@JoinTable(name = "roles_permissions",
			joinColumns = {
			@JoinColumn(name = "role_id", referencedColumnName = "id")}, inverseJoinColumns = {
			@JoinColumn(name = "permission_id", referencedColumnName = "id")})
	private List<Permission> permissions;


	@Builder
	public Role(final Long id, final String name, final String description, final Boolean deleted,final List<Permission> permissions) {
		this.id = id;
		this.deleted = deleted;
		this.name = name;
		this.description = description;
		this.permissions=permissions;
	}
}
