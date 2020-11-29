package br.ufrn.imd.stonks.framework.framework.repository;

import br.ufrn.imd.stonks.framework.framework.model.Despesa;
import br.ufrn.imd.stonks.framework.framework.model.DespesaAtivo;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DespesaAtivoRepository extends AbstractRepository<DespesaAtivo>{

    @Query("SELECT ca, a.codigo FROM DespesaAtivo ca JOIN AtivoAbstract a ON ca.ativoAbstract.id = a.id WHERE ca.despesa.id = :id AND ca.operacao = 'COMPRA'")
    public List<DespesaAtivo> findByAtivosCarteiraCompra(@Param("id") int id);

    @Query("SELECT ca, a.codigo FROM DespesaAtivo ca JOIN Ativo a ON ca.ativoAbstract.id = a.id WHERE ca.despesa.id = :id")
    public List<DespesaAtivo> findAllByDespesaCompra(@Param("id") int id, Sort sort);

    public DespesaAtivo[] findAllByDespesa(Despesa despesa);

    @Query(value = "SELECT SUM(ca.quantidade * ca.valor) FROM DespesaAtivo ca WHERE ca.despesa.id = :idDespesa")
    public Double totalDespesa(Integer idDespesa);
}
