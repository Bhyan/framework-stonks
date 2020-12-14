package br.ufrn.imd.stonks.framework.framework.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "carteira_ativo")
public class DespesaAtivoFramework extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "despesa_id")
    private DespesaFramework despesa;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ativo_id")
    private AtivoFramework ativo;

    @Column(name = "valor")
    private double valor;

    @Column(name = "quantidade")
    private int quantidade;

    @Column( name = "data_transacao")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dataTransacao;

    public DespesaAtivoFramework(
            @NotNull(message = "DespesaFramework é obrigatoria.") DespesaFramework despesa,
            @NotNull(message = "Ativo é obrigatorio.") AtivoFramework ativo,
            double valor,
            int quantidade,
            Date dataTransacao) {
        this.despesa = despesa;
        this.ativo = ativo;
        this.valor = valor;
        this.quantidade = quantidade;
        this.dataTransacao = dataTransacao;
    }

    public DespesaAtivoFramework() { }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DespesaFramework getDespesa() {
        return despesa;
    }

    public void setDespesa(DespesaFramework despesa) {
        this.despesa = despesa;
    }

    public AtivoFramework getAtivo() {
        return ativo;
    }

    public void setAtivo(AtivoFramework ativo) {
        this.ativo = ativo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }
}
