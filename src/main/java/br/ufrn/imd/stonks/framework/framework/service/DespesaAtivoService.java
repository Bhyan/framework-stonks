package br.ufrn.imd.stonks.framework.framework.service;

import br.ufrn.imd.stonks.framework.framework.model.DespesaAtivo;
import br.ufrn.imd.stonks.framework.framework.repository.DespesaAtivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DespesaAtivoService {

    @Autowired
    DespesaAtivoRepository despesaAtivoRepository;

    public boolean isAlreadyPresent(DespesaAtivo despesaAtivo) {
        return despesaAtivoRepository.findById(despesaAtivo.getId()).isPresent();
    }

    public void salvar(DespesaAtivo despesaAtivo) {
        despesaAtivoRepository.save(despesaAtivo);
    }
}
