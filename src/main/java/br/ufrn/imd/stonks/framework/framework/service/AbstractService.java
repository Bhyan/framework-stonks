package br.ufrn.imd.stonks.framework.framework.service;

import br.ufrn.imd.stonks.framework.framework.exception.AbstractEntityException;
import br.ufrn.imd.stonks.framework.framework.model.AbstractEntity;
import br.ufrn.imd.stonks.framework.framework.repository.AbstractRepository;

import java.util.List;
import java.util.Optional;

public abstract class AbstractService<T extends AbstractEntity> {

    protected abstract AbstractRepository<T> getRepository();

    public List<T> getAll() {
        return getRepository().findAll();
    }

    public Optional<T> getById(Integer id) throws AbstractEntityException {
        if (id == null) {
            return null;
        }

        if (!getRepository().existsById(id)) {
            throw new AbstractEntityException("O objeto procurado não existe no banco!");
        }

        return getRepository().findById(id);
    }

    public void add(T entity) throws AbstractEntityException {

        verifyFields(entity);
        validateEntity(entity);
        getRepository().save(entity);
    }

    public void update(T entity) throws AbstractEntityException {

        getById(entity.getId());
        validateEntity(entity);
        getRepository().save(updateValues(getRepository().getOne(entity.getId()), entity));
    }

    public void remove(Integer id) throws AbstractEntityException {
        getById(id);
        getRepository().deleteById(id);
    }

    public abstract void verifyFields(T entity) throws AbstractEntityException;

    public abstract void validateEntity(T entity) throws AbstractEntityException;

    public abstract T updateValues(T oldEntity, T entity);
}
