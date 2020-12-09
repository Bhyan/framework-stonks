package br.ufrn.imd.stonks.framework.framework.service;

import br.ufrn.imd.stonks.framework.framework.model.DespesaAtivo;
import br.ufrn.imd.stonks.framework.framework.model.DespesaAtivoValorAbstract;
import br.ufrn.imd.stonks.framework.framework.repository.DespesaAtivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public abstract class DespesaAtivoService {

    @Autowired
    DespesaAtivoRepository despesaAtivoRepository;

    public boolean isAlreadyPresent(DespesaAtivo despesaAtivo) {
        return despesaAtivoRepository.findById(despesaAtivo.getId()).isPresent();
    }

    public void salvar(DespesaAtivo despesaAtivo) {
        despesaAtivoRepository.save(despesaAtivo);
    }

    public List<DespesaAtivo> findByAtivosDespesa(int id, HashMap<String, String> params){
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

    public abstract List<DespesaAtivoValorAbstract> gerarDadosRelatorio(List<DespesaAtivo> ativos);
}
