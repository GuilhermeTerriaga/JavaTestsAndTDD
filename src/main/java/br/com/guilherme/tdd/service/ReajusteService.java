package br.com.guilherme.tdd.service;

import br.com.guilherme.tdd.model.DesempenhoEnum;
import br.com.guilherme.tdd.model.Funcionario;

public class ReajusteService {

    public void reajusta(Funcionario funcionario, DesempenhoEnum desempenho) {
        funcionario.reajustaSalario(
                funcionario.getSalario().multiply(desempenho.percentualReajuste()));
    }

}
