package br.ufrn.imd.stonks.framework.framework.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "usuario")
public abstract class UsuarioAbstract extends AbstractEntity {

    @NotNull(message = "Nome é obrigatorio.")
    private String nome;

    @NotNull(message = "Email é obrigatorio.")
    @Email(message = "Email invalido")
    @Column(unique = true)
    private String email;

    @NotNull(message = "Senha é obrigatorio.")
    @Column(unique = true)
    private String password;

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;

    public UsuarioAbstract(@NotNull(message = "Nome é obrigatorio.") String nome,
                           @NotNull(message = "Email é obrigatorio.") @Email(message = "Email invalido") String email,
                           @NotNull(message = "Senha é obrigatorio.") String password,
                           Boolean status) {
        this.nome = nome;
        this.email = email;
        this.password = password;
    }

    public UsuarioAbstract() { }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
