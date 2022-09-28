package modelo;

import exception.InvalidNumberException;

public abstract class Conta {
    private int numero;
    private double saldo;
    private Cliente cliente;

    public Conta(int numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
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
    public String toString() {
        return "numero=" + numero +
                ", saldo=" + saldo +
                ", cliente=" + cliente;
    }
}
