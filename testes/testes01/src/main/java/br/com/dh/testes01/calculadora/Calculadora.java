package br.com.dh.testes01.calculadora;

public class Calculadora {

    public double soma(double n1, double n2) {
        return n1 + n2;
    }

    public double dividir(double n1, double n2) {
        if (n2 == 0) {
            return 0;
        }
        return n1 / n2;
    }
}
