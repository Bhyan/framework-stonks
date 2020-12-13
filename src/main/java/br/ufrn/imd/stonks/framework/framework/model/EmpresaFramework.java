package br.ufrn.imd.stonks.framework.framework.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "empresa")
public class EmpresaFramework extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false)
    private Long cnpj;

   /* @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "empresa")
    private List<AtivoFramework> ativo;*/

    public EmpresaFramework() { }

    public EmpresaFramework(String nome, Long cnpj/*, List<AtivoFramework> ativoAbstracts*/) {
        this.nome = nome;
        this.cnpj = cnpj;
//        this.ativo = ativoAbstracts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
/*
    public List<AtivoFramework> getAtivos() {
        return ativo;
    }

    public void setAtivos(List<AtivoFramework> ativo) {
        this.ativo = ativo;
    }*/
}
