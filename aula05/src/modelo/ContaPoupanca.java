package modelo;

import exception.InvalidNumberException;

public class ContaPoupanca extends Conta {
    private static double taxa = 0.1;

    public ContaPoupanca(int numero, Cliente cliente) {
        super(numero, cliente);
    }

    public static double getTaxa() {
        return taxa;
    }

    public static void setTaxa(double taxa) {
        ContaPoupanca.taxa = taxa;
    }

    @Override
    public boolean sacar(double valor) throws InvalidNumberException {
        if(saldoInsuficiente(valor)) {
            return false;
        }
        return super.sacar(valor + taxa);
    }

    private boolean saldoInsuficiente(double valor) {
        return getSaldo() < valor + taxa;
    }

    @Override
    public String toString() {
        return "Conta Poupança: " + super.toString();
    }
}
