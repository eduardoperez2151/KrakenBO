package com.geocom.models.abstracts;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public abstract class AbstractDescribableEntity<K extends Serializable> extends AbstractBaseAuditableEntity<K> {

	private static final long serialVersionUID = 7974931986202307508L;

	@Column
	protected String name;

	@Column
	protected String description;

}
