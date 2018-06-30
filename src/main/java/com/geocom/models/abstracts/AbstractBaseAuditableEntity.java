package com.geocom.models.abstracts;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractBaseAuditableEntity<K extends Serializable> extends AbstractBaseEntity<K> {

	private static final long serialVersionUID = -272086659648713483L;

	@Column
	@CreatedDate
	protected LocalDateTime createdDate;

	@Column
	@LastModifiedDate
	protected LocalDateTime lastModifiedDate;
}