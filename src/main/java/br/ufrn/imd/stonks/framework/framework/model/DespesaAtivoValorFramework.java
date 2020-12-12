package br.ufrn.imd.stonks.framework.framework.model;

//@MappedSuperclass
//@EntityListeners(AuditingEntityListener.class)
public class DespesaAtivoValorFramework {
    private DespesaAtivoFramework despesaAtivo;
    private Float valor;

    public DespesaAtivoValorFramework() {
    }

    public DespesaAtivoValorFramework(
            DespesaAtivoFramework despesaAtivo,
            Float valor) {
        this.despesaAtivo = despesaAtivo;
        this.valor = valor;
    }

    public DespesaAtivoFramework getDespesaAtivo() {
        return despesaAtivo;
    }

    public void setDespesaAtivo(DespesaAtivoFramework despesaAtivo) {
        this.despesaAtivo = despesaAtivo;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }
}
