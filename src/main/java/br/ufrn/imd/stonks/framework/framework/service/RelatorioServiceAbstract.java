package br.ufrn.imd.stonks.framework.framework.service;

import br.ufrn.imd.stonks.framework.framework.model.Despesa;
import br.ufrn.imd.stonks.framework.framework.model.DespesaAtivo;
import br.ufrn.imd.stonks.framework.framework.model.DespesaAtivoValorAbstract;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class RelatorioServiceAbstract {

    @Autowired
    DespesaServiceAbstract despesaServiceAbstract;

    @Autowired
    DespesaAtivoService despesaAtivoService;

    public abstract List<DespesaAtivoValorAbstract> listarDespesasAtivoValor(List<DespesaAtivo> despesaAtivos);

    public List<DespesaAtivoValorAbstract> gerarDadosRelatorio() {
        Despesa despesa = despesaServiceAbstract.despesaByUsuario();

        List<DespesaAtivo> despesaAtivoList = despesaAtivoService.findByAtivosDespesa(despesa.getId(), null);

        List<DespesaAtivoValorAbstract> despesaAtivoValorAbstractList = listarDespesasAtivoValor(despesaAtivoList);

        return despesaAtivoValorAbstractList;
    }
}
