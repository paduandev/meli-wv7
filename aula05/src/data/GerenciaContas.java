package data;

import exception.ContaInexistenteException;
import exception.InvalidNumberException;
import modelo.*;
import util.NumberGenerator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GerenciaContas {
    NumberGenerator numberGenerator;
    private Map<Integer, Conta> contas;

    public GerenciaContas() {
        contas = new HashMap<>();
        numberGenerator = NumberGenerator.getInstance();
    }

    public void novaContaCorrente(Cliente cliente) {
        int numeroConta = numberGenerator.getNext();
        contas.put(numeroConta, new ContaCorrente(numeroConta, cliente));
    }

    public void novaContaEspecial(Cliente cliente, double limite) {
        int numeroConta = numberGenerator.getNext();
        contas.put(numeroConta, new ContaEspecial(numeroConta, cliente, limite));
    }

    public void novaContaPoupanca(Cliente cliente) {
        int numeroConta = numberGenerator.getNext();
        contas.put(numeroConta, new ContaPoupanca(numeroConta, cliente));
    }

    public void depositar(int numeroConta, double valor) throws ContaInexistenteException,
            InvalidNumberException {
        Conta conta = contas.get(numeroConta);
        if (conta == null) {
            throw new ContaInexistenteException("Conta não existe");
        }
        conta.depositar(valor);
    }

    public boolean sacar(int numeroConta, double valor) throws ContaInexistenteException, InvalidNumberException {
        Conta conta = contas.get(numeroConta);
        if (conta == null) {
            throw new ContaInexistenteException("Conta não existe");
        }
        return conta.sacar(valor);
    }

    public String obterDadosConta(int numeroConta) throws ContaInexistenteException {
        Conta conta = contas.get(numeroConta);
        if (conta == null) {
            throw new ContaInexistenteException("Conta não existe");
        }
        return conta.toString();
    }

    public void transferir(int numeroContaOrigem, int numeroContaDestino, double valor) throws ContaInexistenteException, InvalidNumberException {
        Conta contaOrigem = contas.get(numeroContaOrigem);
        Conta contaDestino = contas.get(numeroContaDestino);
        if (contaOrigem == null || contaDestino == null) {
            throw new ContaInexistenteException("Conta não existe");
        }
        boolean saqueRealizado = contaOrigem.sacar(valor);

        if(saqueRealizado) {
            contaDestino.depositar(valor);
        }
    }

    public List<String> listarTodasContas() {
        return contas.values().stream()
                .map(c -> c.toString() + "\n")
                .collect(Collectors.toList());
    }

    public List<String> listarContaCorrentePorNumero() {
        return contas.values().stream()
                .filter(c-> c instanceof ContaCorrente)
                .sorted((c1, c2)->c1.getNumero() - c2.getNumero())
                .map(c->c.toString())
                .collect(Collectors.toList());
    }


}
