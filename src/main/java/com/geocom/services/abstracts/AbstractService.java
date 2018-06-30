package com.geocom.services.abstracts;

import com.geocom.dtos.Identifiable;
import com.geocom.services.Service;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

public abstract class AbstractService<D extends Identifiable<K>, E, K> implements Service<D, K> {

    protected JpaRepository<E, K> repository;
    protected ConversionService conversionService;
    private Class<D> dtoClass;
    private Class<E> entityClass;

    public AbstractService(final JpaRepository repository, final ConversionService conversionService, final Class<D> dtoClass, final Class<E> entityClass) {
        this.repository = repository;
        this.conversionService = conversionService;
        this.dtoClass = dtoClass;
        this.entityClass = entityClass;
    }

    @Override
    public List<D> getAll() {
        final TypeDescriptor sourceType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(entityClass));
        final TypeDescriptor targetType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(dtoClass));
        final List<E> entities = this.repository.findAll();
        return (List<D>) this.conversionService.convert(entities, sourceType, targetType);
    }

    @Override
    public D get(K id) {
        final E entity = this.findEntity(id);
        return this.conversionService.convert(entity, dtoClass);
    }

    @Override
    public D create(D dto) {
        if (dto.getId() != null) {
            this.existEntity(dto.getId());
        }
        final E entity = this.conversionService.convert(dto, entityClass);
        final E persistedEntity = this.repository.save(entity);
        return this.conversionService.convert(persistedEntity, dtoClass);
    }

    @Override
    public D update(D dto) {
        this.findEntity(dto.getId());
        final E entity = this.conversionService.convert(dto, entityClass);
        final E updatedEntity = this.repository.save(entity);
        return this.conversionService.convert(updatedEntity, dtoClass);
    }

    @Override
    public void delete(K id) {
        final E entity = this.findEntity(id);
        this.repository.delete(entity);
    }

    protected E findEntity(final K id) {
        final Optional<E> optionalEntity = this.repository.findById(id);
        return optionalEntity
                .orElseThrow(() -> new EntityNotFoundException(String.format("La entidad con id %d no existe", id)));
    }

    protected void existEntity(final K id) {
        final Optional<E> optionalEntity = this.repository.findById(id);
        if (optionalEntity.isPresent()) {
            throw new EntityExistsException(String.format("La entidad con id %d ya existe", id));
        }
    }

    protected E getEntity(final K id) {
        final Optional<E> optionalEntity = this.repository.findById(id);
        return optionalEntity.orElse(null);
    }
}
