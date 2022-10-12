package br.com.guilherme.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import br.com.guilherme.tdd.model.DesempenhoEnum;
import br.com.guilherme.tdd.model.Funcionario;
import br.com.guilherme.tdd.service.ReajusteService;

public class ReajusteServiceTest {
    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach
    public void inicializar() {
        this.funcionario = new Funcionario("null", LocalDate.now(), new BigDecimal("1000.00"));
        this.service = new ReajusteService();
    }

    @AfterEach
    public void finalizar() {
        System.out.println("Acabou");
    }

    @AfterAll
    public static void depoisDeTodos() {
        System.out.println("Depois de todos");
    }

    @BeforeAll
    public static void antesDeTodos() {
        System.out.println("Antes de todos");
    }

    @Test
    public void deveSerTresPctSalario() {
        service.reajusta(funcionario, DesempenhoEnum.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void deveSerQuinzePctSalario() {
        service.reajusta(funcionario, DesempenhoEnum.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void deveSerVintePctSalario() {
        service.reajusta(funcionario, DesempenhoEnum.ÓTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
