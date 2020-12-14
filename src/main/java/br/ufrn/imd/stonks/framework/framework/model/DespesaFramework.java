package br.ufrn.imd.stonks.framework.framework.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "carteira")
public class DespesaFramework extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @NotNull(message = "É preciso definir um usuario.")
    @JoinColumn(name = "usuario_id")
    private UsuarioFramework usuario;

    @OneToMany(mappedBy = "despesa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<DespesaAtivoFramework> carteiraAtivos;

    public DespesaFramework(@NotNull(message = "É preciso definir um usuario.") UsuarioFramework usuario) {
        this.usuario = usuario;
    }

    public DespesaFramework() { }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UsuarioFramework getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioFramework usuario) {
        this.usuario = usuario;
    }

    public Set<DespesaAtivoFramework> getCarteiraAtivos() {
        return carteiraAtivos;
    }

    public void setCarteiraAtivos(Set<DespesaAtivoFramework> carteiraAtivos) {
        this.carteiraAtivos = carteiraAtivos;
    }
}
