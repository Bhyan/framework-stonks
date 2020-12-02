package br.ufrn.imd.stonks.framework.framework.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance
public class EmpresaAbstract extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false)
    private Long cnpj;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "empresa")
    private List<AtivoAbstract> ativoAbstracts;

    public EmpresaAbstract() { }

    public EmpresaAbstract(String nome, Long cnpj, List<AtivoAbstract> ativoAbstracts) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.ativoAbstracts = ativoAbstracts;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
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

    public List<AtivoAbstract> getAtivos() {
        return ativoAbstracts;
    }

    public void setAtivos(List<AtivoAbstract> ativoAbstracts) {
        this.ativoAbstracts = ativoAbstracts;
    }
}
