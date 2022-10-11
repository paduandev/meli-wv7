package br.com.dh.testes03.modelo;

import br.com.dh.testes03.exception.InvalidNumberException;
import lombok.Getter;

@Getter
public abstract class Conta implements Comparable<Conta> {
    private int numero;
    private double saldo;
    private String cliente;

    public Conta(int numero, String cliente) {
        this.numero = numero;
        this.cliente = cliente;
    }

    public void depositar(double valor) throws InvalidNumberException {
        if(valor <= 0 ) {
            throw new InvalidNumberException("O valor é inválido");
        }
        saldo += valor;
    }

    public boolean sacar(double valor) throws InvalidNumberException {
        if(valor <= 0 ) {
            throw new InvalidNumberException("O valor é inválido");
        }
        saldo -= valor;
        return true;
    }

    @Override
    public java.lang.String toString() {
        return "numero=" + numero +
                ", saldo=" + saldo +
                ", string=" + cliente;
    }

    @Override
    public int compareTo(Conta outraConta) {
        if (this.saldo < outraConta.getSaldo()) {
            return -1;
        }
        if (this.saldo > outraConta.getSaldo()) {
            return 1;
        }
        return 0;
    }
}
