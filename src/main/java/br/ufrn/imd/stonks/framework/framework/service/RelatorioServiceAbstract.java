package br.ufrn.imd.stonks.framework.framework.service;

import br.ufrn.imd.stonks.framework.framework.exception.AbstractEntityException;

public abstract class RelatorioServiceAbstract extends AbstractService {

    public abstract void enviarRelatorio() throws AbstractEntityException;
}
