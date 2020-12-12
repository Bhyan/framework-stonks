package br.ufrn.imd.stonks.framework.framework.service;

import br.ufrn.imd.stonks.framework.framework.model.DespesaFramework;
import br.ufrn.imd.stonks.framework.framework.model.DespesaAtivoFramework;
import br.ufrn.imd.stonks.framework.framework.model.DespesaAtivoValorFramework;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class RelatorioServiceAbstract {

    @Autowired
    private DespesaServiceAbstract despesaService;

    @Autowired
    private DespesaAtivoServiceAbstract despesaAtivoService;

    public abstract List<DespesaAtivoValorFramework> listarDespesasAtivoValor(List<DespesaAtivoFramework> despesaAtivos);

    public List<DespesaAtivoValorFramework> gerarDadosRelatorio() {
        DespesaFramework despesa = despesaService.despesaByUsuario();

        List<DespesaAtivoFramework> despesaAtivoList = despesaAtivoService.findByAtivosDespesa(despesa.getId(), null);

        List<DespesaAtivoValorFramework> despesaAtivoValorAbstractList = listarDespesasAtivoValor(despesaAtivoList);

        return despesaAtivoValorAbstractList;
    }
}
