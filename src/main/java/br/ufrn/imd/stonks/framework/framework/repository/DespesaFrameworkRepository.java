package br.ufrn.imd.stonks.framework.framework.repository;

import br.ufrn.imd.stonks.framework.framework.model.DespesaFramework;
import br.ufrn.imd.stonks.framework.framework.model.UsuarioFramework;
import org.springframework.stereotype.Repository;

@Repository
public interface DespesaFrameworkRepository extends RepositoryFramework<DespesaFramework> {

    public DespesaFramework findById(int id);

    public DespesaFramework findByUsuario(UsuarioFramework usuarioAbstract);
}
