package br.ufrn.imd.stonks.framework.framework.service;

import br.ufrn.imd.stonks.framework.framework.model.AbstractEntity;
import br.ufrn.imd.stonks.framework.framework.model.AtivoAbstract;
import br.ufrn.imd.stonks.framework.framework.model.Despesa;

public abstract class CarteiraServiceAbstract extends AbstractService {

    public abstract void adicionarAtivo(AtivoAbstract ativoAbstract);

    public abstract void removerAtivo(AtivoAbstract ativoAbstract);

    public AbstractEntity visualisarCarteira() {
        return null;
    }
}
