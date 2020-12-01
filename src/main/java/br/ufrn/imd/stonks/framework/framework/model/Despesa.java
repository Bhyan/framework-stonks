package br.ufrn.imd.stonks.framework.framework.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
public class Despesa extends AbstractEntity {

    @NotNull(message = "É preciso definir um usuario.")
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioAbstract usuario;

    @Column(name = "status")
    private Boolean status;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "carteira_id")
    private DespesaAtivo carteiraAtivos;

    public Despesa(@NotNull(message = "É preciso definir um usuario.") UsuarioAbstract usuario) {
        this.usuario = usuario;
        this.status = true;
    }
    public Despesa() { }

    public UsuarioAbstract getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioAbstract usuario) {
        this.usuario = usuario;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public DespesaAtivo getCarteiraAtivos() {
        return carteiraAtivos;
    }

    public void setCarteiraAtivos(DespesaAtivo carteiraAtivos) {
        this.carteiraAtivos = carteiraAtivos;
    }
}
