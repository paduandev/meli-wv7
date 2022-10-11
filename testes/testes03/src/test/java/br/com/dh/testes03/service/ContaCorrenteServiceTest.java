package br.com.dh.testes03.service;

import br.com.dh.testes03.dao.ContaDAO;
import br.com.dh.testes03.exception.ContaInexistenteException;
import br.com.dh.testes03.exception.InvalidNumberException;
import br.com.dh.testes03.modelo.ContaCorrente;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ContaCorrenteServiceTest {

    @InjectMocks
    private ContaCorrenteService service;

    @Mock
    private ContaDAO dao;


    @Test
    @DisplayName("Valida nova Conta")
    void novaContaCorrente_retorneNovaContaCorrente_quandoSucesso() {
        final String nomeCliente = "Cliente 1";
        final int numeroConta = 1;
        ContaCorrente novaConta = new ContaCorrente(numeroConta, nomeCliente);

        Mockito.when(dao.novaContaCorrente(ArgumentMatchers.anyString()))
                .thenReturn(novaConta);

        ContaCorrente cc = service.novaContaCorrente(nomeCliente);

        assertThat(cc).isNotNull();
        assertThat(cc.getNumero()).isPositive();
        assertThat(cc.getCliente()).isEqualTo(nomeCliente);
    }

    @Test
    void getConta_retornaContaCorrente_quandoContaExiste() throws ContaInexistenteException {
        final String nomeCliente = "Cliente 1";
        final int numeroConta = 1;
        ContaCorrente novaConta = new ContaCorrente(numeroConta, nomeCliente);

        Mockito.when(dao.getContaCorrente(ArgumentMatchers.anyInt()))
                .thenReturn(novaConta);

        ContaCorrente contaCorrenteFound = service.getConta(numeroConta);

        assertThat(contaCorrenteFound).isNotNull();
        assertThat(contaCorrenteFound.getNumero()).isEqualTo(numeroConta);
        assertThat(contaCorrenteFound.getSaldo()).isZero();
    }

    @Test
    void getConta_lancaContaInexistenteException_quantoContaNaoExiste() throws ContaInexistenteException {
        int numeroContaInexistente = 999;

        BDDMockito.given(dao.getContaCorrente(ArgumentMatchers.anyInt()))
                .willThrow(new ContaInexistenteException("Conta não existe"));

        assertThrows(ContaInexistenteException.class, () -> {
            service.getConta(numeroContaInexistente);
        });
    }

    @Test
    void sacar_returnTrue_quandoContaExisteEValorValidoESaldoSuficiente() throws InvalidNumberException, ContaInexistenteException {
        final String nomeCliente = "Cliente 1";
        final int numeroConta = 1;
        final double valorOperacao = 100;

        ContaCorrente novaConta = new ContaCorrente(numeroConta, nomeCliente);
        novaConta.depositar(valorOperacao);

        Mockito.when(dao.getContaCorrente(ArgumentMatchers.anyInt()))
                .thenReturn(novaConta);
        Mockito.when(dao.updateConta(ArgumentMatchers.any()))
                .thenReturn(true);

        boolean sucesso = service.sacar(numeroConta, valorOperacao);

        assertThat(sucesso).isTrue();
        assertThat(novaConta.getSaldo()).isZero();
    }

    @Test
    void sacar_lancaContaInexistenteException_quandoContaNaoExiste() throws ContaInexistenteException {
        int numeroContaInexistente = 999;
        double valorOpercao = 100;

        BDDMockito.given(dao.getContaCorrente(ArgumentMatchers.anyInt()))
                .willThrow(new ContaInexistenteException("Conta não existe"));

        assertThrows(ContaInexistenteException.class, () -> {
            service.sacar(numeroContaInexistente, valorOpercao);
        });

        verify(dao, never()).updateConta(ArgumentMatchers.any());
    }

    @Test
    void sacar_lancarInvalidNumberException_quandoValorOperacaoInvalido() throws ContaInexistenteException {
        final String nomeCliente = "Cliente 1";
        final int numeroConta = 1;
        final double valorOperacao = -100;

        ContaCorrente novaConta = new ContaCorrente(numeroConta, nomeCliente);

        Mockito.when(dao.getContaCorrente(ArgumentMatchers.anyInt()))
                .thenReturn(novaConta);

        assertThrows(InvalidNumberException.class, () -> {
            service.sacar(numeroConta, valorOperacao);
        });

        verify(dao, never()).updateConta(ArgumentMatchers.any());
    }

    @Test
    void depositar() {
    }
}