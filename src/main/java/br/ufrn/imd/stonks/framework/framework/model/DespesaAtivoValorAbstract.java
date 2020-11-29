package br.ufrn.imd.stonks.framework.framework.model;

public class DespesaAtivoValorAbstract {
    private DespesaAtivo despesaAtivo;
    private Float valor;

    public DespesaAtivoValorAbstract() {
    }

    public DespesaAtivoValorAbstract(
            DespesaAtivo despesaAtivo,
            Float valor) {
        this.despesaAtivo = despesaAtivo;
        this.valor = valor;
    }

    public DespesaAtivo getDespesaAtivo() {
        return despesaAtivo;
    }

    public void setDespesaAtivo(DespesaAtivo despesaAtivo) {
        this.despesaAtivo = despesaAtivo;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }
}
