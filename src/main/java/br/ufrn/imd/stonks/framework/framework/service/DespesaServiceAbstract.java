package br.ufrn.imd.stonks.framework.framework.service;

import br.ufrn.imd.stonks.framework.framework.exception.AbstractEntityException;
import br.ufrn.imd.stonks.framework.framework.model.*;
import br.ufrn.imd.stonks.framework.framework.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class DespesaServiceAbstract<T> {

    @Autowired
    private DespesaRepository despesaRepository;

    @Autowired
    private DespesaAtivoService despesaAtivoService;

    public abstract DespesaAtivo adicionarAtivo(Despesa despesa, DespesaAtivo despesaAtivo);

    public abstract boolean removerAtivo(DespesaAtivo despesaAtivo);

    public abstract Despesa despesaByUsuario();
    public abstract void salvarDespesa(Despesa despesa);

    public AbstractEntity visualisarCarteira() {

        return null;
    }

    public void adicionar(DespesaAtivo despesaAtivo, UsuarioAbstract usuarioAbstract) throws AbstractEntityException {
        Despesa despesa = despesaByUsuario();

        if (despesa == null) {
            despesa = new Despesa(usuarioAbstract);
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

    public String remover(DespesaAtivo despesaAtivo, UsuarioAbstract usuarioAbstract) throws AbstractEntityException{
        if(!removerAtivo(despesaAtivo)){
            throw new AbstractEntityException("Nao foi possivel remover a despesa");
        }
        else {
            return "despesa removida com sucesso";
        }
    }

//    public void salvarDespesa(Despesa despesa) {
//        despesaRepository.save(despesa);
//    }
}
