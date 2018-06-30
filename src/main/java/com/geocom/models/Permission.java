package com.geocom.models;

import com.geocom.models.abstracts.AbstractDescribableEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "permissions")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Permission extends AbstractDescribableEntity<Long> {

    @Builder
    public Permission(final Long id,final String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
