package br.ufrn.imd.stonks.framework.framework.service;

import br.ufrn.imd.stonks.framework.framework.exception.AbstractEntityException;
import br.ufrn.imd.stonks.framework.framework.model.DespesaAtivoFramework;
import br.ufrn.imd.stonks.framework.framework.model.DespesaFramework;
import br.ufrn.imd.stonks.framework.framework.model.UsuarioFramework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class DespesaServiceAbstract {

    @Autowired
    private DespesaAtivoServiceAbstract despesaAtivoService;

    public abstract DespesaAtivoFramework adicionarAtivo(DespesaFramework despesa, DespesaAtivoFramework despesaAtivo);

    public abstract boolean removerAtivo(DespesaAtivoFramework despesaAtivo);

    public abstract DespesaFramework despesaByUsuario();

    public abstract void salvarDespesa(DespesaFramework despesa);

    public void adicionar(DespesaAtivoFramework despesaAtivo, UsuarioFramework usuarioAbstract) throws AbstractEntityException {
        DespesaFramework despesa = despesaByUsuario();

        if (despesa == null) {
            despesa = new DespesaFramework(usuarioAbstract);
            salvarDespesa(despesa);
        }

        despesaAtivo = adicionarAtivo(despesa, despesaAtivo);

        if (despesaAtivoService.isAlreadyPresent(despesaAtivo)){
            throw new AbstractEntityException("Esta despesa ja existe");
        }
        else{
            despesaAtivoService.salvar(despesaAtivo);
        }
    }

    public String remover(DespesaAtivoFramework despesaAtivo) throws AbstractEntityException{
        if(!removerAtivo(despesaAtivo)){
            throw new AbstractEntityException("Nao foi possivel remover a despesa");
        }
        else {
            return "despesa removida com sucesso";
        }
    }

}
