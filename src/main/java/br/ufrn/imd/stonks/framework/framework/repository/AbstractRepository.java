package br.ufrn.imd.stonks.framework.framework.repository;

import br.ufrn.imd.stonks.framework.framework.model.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbstractRepository <T extends AbstractEntity> extends JpaRepository<T,Integer> {

    @Override
    @Query(value = "SELECT * FROM #{#entityName}", nativeQuery=true)
    List<T> findAll();
}
