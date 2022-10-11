package br.com.dh.testes03.dao;

import br.com.dh.testes03.exception.ContaInexistenteException;
import br.com.dh.testes03.modelo.Conta;
import br.com.dh.testes03.modelo.ContaCorrente;
import br.com.dh.testes03.modelo.ContaEspecial;
import br.com.dh.testes03.modelo.ContaPoupanca;
import br.com.dh.testes03.util.NumberGenerator;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ContaDAO {
    NumberGenerator numberGenerator;
    private Map<Integer, Conta> contas;

    public ContaDAO() {
        contas = new HashMap<>();
        numberGenerator = NumberGenerator.getInstance();

        // Dados testes
        int numeroConta = numberGenerator.getNext();
        contas.put(numeroConta, new ContaCorrente(numeroConta, "Cliente 1"));
        numeroConta = numberGenerator.getNext();
        contas.put(numeroConta, new ContaEspecial(numeroConta, "Cliente 2", 1000));
        numeroConta = numberGenerator.getNext();
        contas.put(numeroConta, new ContaPoupanca(numeroConta, "Cliente 3"));
    }

    public ContaCorrente novaContaCorrente(String cliente) {
        int numeroConta = numberGenerator.getNext();
        ContaCorrente cc = new ContaCorrente(numeroConta, cliente);
        contas.put(numeroConta, cc);
        return cc;
    }

    public void novaContaEspecial(String cliente, double limite) {
        int numeroConta = numberGenerator.getNext();
        contas.put(numeroConta, new ContaEspecial(numeroConta, cliente, limite));
    }

    public void novaContaPoupanca(String cliente) {
        int numeroConta = numberGenerator.getNext();
        contas.put(numeroConta, new ContaPoupanca(numeroConta, cliente));
    }

    public Conta getConta(int numeroConta) throws ContaInexistenteException {
        Conta conta = contas.get(numeroConta);

        if (conta != null ) {
            return conta;
        }

        throw new ContaInexistenteException("Conta Corrente não existe");
    }

    public ContaCorrente getContaCorrente(int numeroConta) throws ContaInexistenteException {
        Conta conta = contas.get(numeroConta);

        if (conta != null && conta instanceof ContaCorrente) {
            return (ContaCorrente) conta;
        }

        throw new ContaInexistenteException("Conta Corrente não existe");
    }

    public ContaEspecial getContaEspecial(int numeroConta) throws ContaInexistenteException {
        Conta conta = contas.get(numeroConta);

        if (conta != null && conta instanceof ContaEspecial) {
            return (ContaEspecial) conta;
        }

        throw new ContaInexistenteException("Conta Especial não existe");
    }

    public ContaPoupanca getContaPoupanca(int numeroConta) throws ContaInexistenteException {
        Conta conta = contas.get(numeroConta);

        if (conta != null && conta instanceof ContaPoupanca) {
            return (ContaPoupanca) conta;
        }

        throw new ContaInexistenteException("Conta Poupança não existe");
    }


    public boolean updateConta(Conta conta) throws ContaInexistenteException {
        Conta contaFound = contas.get(conta.getNumero());
        if (contaFound == null) {
            throw new ContaInexistenteException("Conta " + conta.getNumero() + " não existe");
        }
        contas.put(conta.getNumero(), conta);
        return true;
    }

    public String obterDadosConta(int numeroConta) throws ContaInexistenteException {
        Conta conta = contas.get(numeroConta);
        if (conta == null) {
            throw new ContaInexistenteException("Conta " + numeroConta + " não existe");
        }
        return conta.toString();
    }

    public void remover(int numeroConta) throws ContaInexistenteException {
        Conta conta = contas.remove(numeroConta);
        if (conta == null) {
            throw new ContaInexistenteException("Conta " + numeroConta + " não existe.");
        }
    }

    public List<String> listarTodasContas() {
        return contas.values().stream()
                .map(c -> c.toString() + "\n")
                .collect(Collectors.toList());
    }

    public List<String> listarContaCorrentePorNumero() {
        return contas.values().stream()
                .filter(c -> c instanceof ContaCorrente)
                .sorted(Comparator.comparingInt(Conta::getNumero))
                .map(c -> c.toString())
                .collect(Collectors.toList());
    }

    public List<String> listarContaCorrentePorSaldo() {
        return contas.values().stream()
                .filter(c -> c instanceof ContaCorrente)
                .sorted(Comparator.reverseOrder())
                .map(c -> c.toString())
                .collect(Collectors.toList());
    }

    public List<String> listarContaEspecialNegativa() {
        return contas.values().stream()
                .filter(c -> c instanceof ContaEspecial)
                .filter(c -> c.getSaldo() < 0)
                .sorted(Comparator.reverseOrder())
                .map(c -> c.toString())
                .collect(Collectors.toList());
    }

}
