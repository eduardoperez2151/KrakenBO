package com.geocom.models.abstracts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@MappedSuperclass
public abstract class AbstractBaseEntity<K extends Serializable> implements Serializable {

	private static final long serialVersionUID = -3102370701862137818L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected K id;

}
