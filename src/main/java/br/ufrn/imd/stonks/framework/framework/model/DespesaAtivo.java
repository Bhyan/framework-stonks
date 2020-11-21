package br.ufrn.imd.stonks.framework.framework.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class DespesaAtivo extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "despesa_id")
    private Despesa despesa;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ativo_id")
    private AtivoAbstract ativoAbstract;

    @Column(name = "valor")
    private double valor;

    @Column(name = "quantidade")
    private int quantidade;

    @Column( name = "data_transacao")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dataTransacao;
//
//    @Enumerated(EnumType.STRING)
//    private Operacao operacao;


    public DespesaAtivo(
            @NotNull(message = "Despesa é obrigatoria.") Despesa despesa,
            @NotNull(message = "Ativo é obrigatorio.") AtivoAbstract ativo,
            double valor,
            int quantidade,
            Date dataTransacao) {
        this.despesa = despesa;
        this.ativo = ativo;
        this.valor = valor;
        this.quantidade = quantidade;
        this.dataTransacao = dataTransacao;
    }

    public DespesaAtivo() { }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Despesa getDespesa() {
        return despesa;
    }

    public void setDespesa(Despesa despesa) {
        this.despesa = despesa;
    }

    public AtivoAbstract getAtivoAbstract() {
        return ativoAbstract;
    }

    public void setAtivoAbstract(AtivoAbstract ativoAbstract) {
        this.ativoAbstract = ativoAbstract;
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
