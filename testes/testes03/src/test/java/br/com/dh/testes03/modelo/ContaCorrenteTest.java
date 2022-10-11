package br.com.dh.testes03.modelo;

import br.com.dh.testes03.exception.InvalidNumberException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ContaCorrenteTest {

    private ContaCorrente contaCorrente;

    @BeforeEach
    void setup() {
        contaCorrente = new ContaCorrente(1, "Cliente 1");
    }

    @Test
    void sacar_retorneTrue_quantoHaSaldoSuficiente() throws InvalidNumberException {
        double valorDeposito = 100;
        double valorSaque = 50;
        contaCorrente.depositar(valorDeposito);

        contaCorrente.sacar(valorSaque);

        assertThat(contaCorrente.getSaldo()).isEqualTo(valorDeposito-valorSaque);
    }
}