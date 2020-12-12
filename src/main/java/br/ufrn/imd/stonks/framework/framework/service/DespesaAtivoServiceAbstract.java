package br.ufrn.imd.stonks.framework.framework.service;

import br.ufrn.imd.stonks.framework.framework.model.DespesaAtivoFramework;
import br.ufrn.imd.stonks.framework.framework.model.DespesaAtivoValorFramework;
import br.ufrn.imd.stonks.framework.framework.repository.DespesaAtivoFrameworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public abstract class DespesaAtivoServiceAbstract {

    @Autowired
    private DespesaAtivoFrameworkRepository despesaAtivoRepository;

    public boolean isAlreadyPresent(DespesaAtivoFramework despesaAtivo) {
        return despesaAtivoRepository.findById(despesaAtivo.getId()).isPresent();
    }

    public void salvar(DespesaAtivoFramework despesaAtivo) {
        despesaAtivoRepository.save(despesaAtivo);
    }

    public List<DespesaAtivoFramework> findByAtivosDespesa(int id, HashMap<String, String> params){
        Sort.Direction direction = Sort.Direction.ASC;
        String sortBy = "id";

        if (params != null) {
            if (params.get("order").equals("asc")) {
                direction = Sort.Direction.ASC;
            } else if (params.get("order").equals("desc")) {
                direction = Sort.Direction.DESC;
            }

            if (!params.get("order").isEmpty()) {
                sortBy = params.get("sort");
            }
        }

        Sort sort = Sort.by(direction, sortBy);

        return despesaAtivoRepository.findAllByDespesaCompra(id, sort);
    }

    public abstract List<DespesaAtivoValorFramework> gerarDadosRelatorio(List<DespesaAtivoFramework> ativos);
}
