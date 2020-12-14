package br.ufrn.imd.stonks.framework.framework.model;

import javax.persistence.*;

@Entity
@Table(name = "ativo")
public class AtivoFramework extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String codigo;

    public AtivoFramework() { }

    public AtivoFramework(String codigo) {
        this.codigo = codigo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
