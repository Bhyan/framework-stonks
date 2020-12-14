package br.ufrn.imd.stonks.framework.framework.repository;

import br.ufrn.imd.stonks.framework.framework.model.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface RepositoryFramework<T extends AbstractEntity> extends JpaRepository<T,Integer> {

    @Override
    @Query(value = "SELECT * FROM #{#entityName}", nativeQuery=true)
    public List<T> findAll();
}
