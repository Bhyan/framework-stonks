package br.ufrn.imd.stonks.framework.framework.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
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

    @Column(name = "status")
    private Boolean status;

    public UsuarioAbstract(@NotNull(message = "Nome é obrigatorio.") String nome,
                           @NotNull(message = "Email é obrigatorio.") @Email(message = "Email invalido") String email,
                           @NotNull(message = "Senha é obrigatorio.") String password,
                           Boolean status) {
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.status = status;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
