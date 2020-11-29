package br.ufrn.imd.stonks.framework.framework.service;

import br.ufrn.imd.stonks.framework.framework.exception.AbstractEntityException;

public abstract class EmailServiceAbstract {

    public abstract String EnviarNotificacao() throws AbstractEntityException;
}
