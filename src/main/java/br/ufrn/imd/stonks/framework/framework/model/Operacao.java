package br.ufrn.imd.stonks.framework.framework.model;

public enum Operacao {
    VENDA {
        @Override
        public String getDenominacao() {
            return "Venda";
        }
    },
    COMPRA {
        @Override
        public String getDenominacao() { return "Compra"; }

    };

    public abstract String getDenominacao();
}
