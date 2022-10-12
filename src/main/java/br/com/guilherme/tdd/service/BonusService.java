package br.com.guilherme.tdd.service;

import java.math.BigDecimal;
import br.com.guilherme.tdd.model.Funcionario;


public class BonusService {

    public BigDecimal calcularBonus(Funcionario funcionario) {
        BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
        if (valor.compareTo(new BigDecimal("1000")) > 0) {
            throw new IllegalArgumentException(
                    "Funcionario com salario alto, não deve receber bonus");
        }
        return valor;
    }

}
