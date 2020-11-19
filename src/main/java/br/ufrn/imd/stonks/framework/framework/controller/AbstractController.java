package br.ufrn.imd.stonks.framework.framework.controller;

import br.ufrn.imd.stonks.framework.framework.exception.AbstractEntityException;
import br.ufrn.imd.stonks.framework.framework.model.AbstractEntity;
import br.ufrn.imd.stonks.framework.framework.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public abstract class AbstractController <T extends AbstractEntity>{

    @Autowired
    protected abstract AbstractService<T> getService();

    public ResponseEntity<List<T>> listAll() {
        return new ResponseEntity<List<T>>(getService().getAll(), HttpStatus.OK);
    }

    public ResponseEntity<T> listById(Integer id) {
        try {
            return new ResponseEntity<T>(getService().getById(id).get(), HttpStatus.OK);
        } catch (AbstractEntityException e) {
            return new ResponseEntity<T>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<String> add(T t) {
        try {
            getService().add(t);
            return new ResponseEntity<String>("Objeto adicionado com sucesso!", HttpStatus.OK);
        } catch (AbstractEntityException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<String> update(T t) {
        try {
            getService().update(t);
            return new ResponseEntity<String>("Objeto atualizado com sucesso!", HttpStatus.OK);
        } catch (AbstractEntityException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<String> remove(Integer id) {
        try {
            getService().remove(id);
            return new ResponseEntity<String>("Objeto removido com sucesso!", HttpStatus.OK);
        } catch (AbstractEntityException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
