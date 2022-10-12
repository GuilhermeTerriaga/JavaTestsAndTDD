package br.com.guilherme.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import br.com.guilherme.tdd.model.Calculadora;

public class CalculadoraTest {
    @Test
    public void somarDoispositivos() {
        assertEquals(42, new Calculadora().somar(20, 22));
    }
}
