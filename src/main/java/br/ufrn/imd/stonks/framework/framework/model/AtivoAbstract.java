package br.ufrn.imd.stonks.framework.framework.model;

import javax.persistence.*;

@Entity
public abstract class AtivoAbstract extends AbstractEntity {

    @Column(unique = true, nullable = false)
    private String codigo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id", nullable = false)
    private EmpresaAbstract empresaAbstract;

    public AtivoAbstract() { }

    public AtivoAbstract(String codigo, EmpresaAbstract empresaAbstract) {
        this.codigo = codigo;
        this.empresaAbstract = empresaAbstract;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public EmpresaAbstract getEmpresa() {
        return empresaAbstract;
    }

    public void setEmpresa(EmpresaAbstract empresaAbstract) {
        this.empresaAbstract = empresaAbstract;
    }
}
