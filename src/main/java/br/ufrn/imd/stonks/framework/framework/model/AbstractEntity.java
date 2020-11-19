package br.ufrn.imd.stonks.framework.framework.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @CreatedDate
    @Column(nullable = true, updatable = false, name = "data_criacao")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao = new Date();

    @LastModifiedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_modificacao")
    private Date dataModificacao;

    @Column
    private Boolean ativo = true;

    @JsonIgnore
    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @JsonIgnore
    public Date getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(Date dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    @PreUpdate
    public void preUpdate() {
        this.dataModificacao = new Date();
    }

    @JsonIgnore
    public Boolean getAtivo() {
        return ativo;
    }

    @JsonIgnore
    public Boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @JsonIgnore
    public abstract Integer getId();

    public abstract void setId(Integer id);
}
