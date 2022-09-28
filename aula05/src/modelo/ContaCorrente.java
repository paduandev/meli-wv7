package modelo;

import exception.InvalidNumberException;

public class ContaCorrente extends Conta {

    public ContaCorrente(int numero, Cliente cliente) {
        super(numero, cliente);
    }

    @Override
    public boolean sacar(double valor) throws InvalidNumberException {
        if(saldoInsuficiente(valor)) {
            return false;
        }
        return super.sacar(valor);
    }

    public boolean saldoInsuficiente(double valor) {
        return getSaldo() < valor;
    }

    @Override
    public String toString() {
        return "Conta Corrente: " + super.toString();
    }
}
