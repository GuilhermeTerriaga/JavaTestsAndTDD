package br.com.guilherme.tdd.model;

import java.math.BigDecimal;

public enum DesempenhoEnum {
    A_DESEJAR {
        @Override
        public BigDecimal percentualReajuste() {
            return new BigDecimal(0.03);
        }
    },
    BOM {
        @Override
        public BigDecimal percentualReajuste() {
            return new BigDecimal(0.15);
        }
    },
    ÓTIMO {
        @Override
        public BigDecimal percentualReajuste() {
            return new BigDecimal(0.20);
        }
    };

    public abstract BigDecimal percentualReajuste();
}
