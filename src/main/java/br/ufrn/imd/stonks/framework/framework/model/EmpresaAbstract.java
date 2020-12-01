package br.ufrn.imd.stonks.framework.framework.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public abstract class EmpresaAbstract extends AbstractEntity {

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false)
    private Long cnpj;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ativo_id")
    private AtivoAbstract ativoAbstract;

    public EmpresaAbstract() { }

    public EmpresaAbstract(String nome, Long cnpj, AtivoAbstract ativoAbstract) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.ativoAbstract = ativoAbstract;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public AtivoAbstract getAtivoAbstract() {
        return ativoAbstract;
    }

    public void setAtivoAbstract(AtivoAbstract ativoAbstract) {
        this.ativoAbstract = ativoAbstract;
    }
}
