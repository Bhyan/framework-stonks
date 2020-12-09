package br.ufrn.imd.stonks.framework.framework.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "carteira")
public class Despesa extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @NotNull(message = "É preciso definir um usuario.")
    @JoinColumn(name = "usuario_id")
    private UsuarioAbstract usuario;

    @OneToMany(mappedBy = "despesa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<DespesaAtivo> carteiraAtivos;

    public Despesa(@NotNull(message = "É preciso definir um usuario.") UsuarioAbstract usuario) {
        this.usuario = usuario;
    }

    public Despesa() { }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public UsuarioAbstract getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioAbstract usuario) {
        this.usuario = usuario;
    }

    public Set<DespesaAtivo> getCarteiraAtivos() {
        return carteiraAtivos;
    }

    public void setCarteiraAtivos(Set<DespesaAtivo> carteiraAtivos) {
        this.carteiraAtivos = carteiraAtivos;
    }
}
