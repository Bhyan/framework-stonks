package br.ufrn.imd.stonks.framework.framework.repository;

import br.ufrn.imd.stonks.framework.framework.model.Despesa;
import br.ufrn.imd.stonks.framework.framework.model.UsuarioAbstract;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface DespesaRepository extends AbstractRepository<Despesa> {

    public Despesa findById(int id);

    public Despesa findByUsuario(UsuarioAbstract usuarioAbstract);
}
