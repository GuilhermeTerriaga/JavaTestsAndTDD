package br.com.guilherme.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import br.com.guilherme.tdd.model.Funcionario;
import br.com.guilherme.tdd.service.BonusService;

public class BonusServiceTest {
    @Test
    void bonusZeroFuncionarioSalarioAlto() {
        BonusService service = new BonusService();
        assertThrows(IllegalArgumentException.class, () -> service.calcularBonus(
                new Funcionario("null", LocalDate.now(), BigDecimal.valueOf(250000.00))));
    }

    @Test
    void bonusZeroFuncionarioSalarioAltoMessage() {
        BonusService service = new BonusService();
        try {
            service.calcularBonus(
                    new Funcionario("null", LocalDate.now(), BigDecimal.valueOf(250000.00)));
            fail("Exception não lançada");
        } catch (Exception e) {
            assertEquals("Funcionario com salario alto, não deve receber bonus", e.getMessage());
        }
    }

    @Test
    void bonusDezPorcentFuncionarioSalario() {
        BonusService service = new BonusService();
        BigDecimal calcularBonus = service
                .calcularBonus(new Funcionario("null", LocalDate.now(), BigDecimal.valueOf(2500)));
        assertEquals(new BigDecimal("250.00"), calcularBonus.setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void bonusDeveDezPorcentSalarioDezMil() {
        BonusService service = new BonusService();
        BigDecimal calcularBonus = service.calcularBonus(
                new Funcionario("null", LocalDate.now(), BigDecimal.valueOf(10000.00)));
        assertEquals(new BigDecimal("1000.00"), calcularBonus.setScale(2, RoundingMode.HALF_UP));
    }
}
