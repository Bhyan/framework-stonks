package br.ufrn.imd.stonks.framework.framework.repository;

import br.ufrn.imd.stonks.framework.framework.model.DespesaFramework;
import br.ufrn.imd.stonks.framework.framework.model.DespesaAtivoFramework;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DespesaAtivoFrameworkRepository extends RepositoryFramework<DespesaAtivoFramework> {

    @Query("SELECT ca, a.codigo FROM DespesaAtivoFramework ca JOIN AtivoFramework a ON ca.ativo.id = a.id WHERE ca.despesa.id = :id")
    public List<DespesaAtivoFramework> findByAtivosCarteiraCompra(@Param("id") int id);

    @Query("SELECT ca, a.codigo FROM DespesaAtivoFramework ca JOIN AtivoFramework a ON ca.ativo.id = a.id WHERE ca.despesa.id = :id")
    public List<DespesaAtivoFramework> findAllByDespesaCompra(@Param("id") int id, Sort sort);

    public DespesaAtivoFramework[] findAllByDespesa(DespesaFramework despesa);

    @Query(value = "SELECT SUM(ca.quantidade * ca.valor) FROM DespesaAtivoFramework ca WHERE ca.despesa.id = :idDespesa")
    public Double totalDespesa(Integer idDespesa);
}
