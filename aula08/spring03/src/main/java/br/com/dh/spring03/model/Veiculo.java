package br.com.dh.spring03.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo implements Comparable<Veiculo> {
    private String placa;
    private String modelo;
    private int ano;
    private double valor;
    private int id_proprietario;


    @Override
    public int compareTo(Veiculo other) {
        if (this.getValor() == other.getValor()) {
            return 0;
        }
        if (this.getValor() < other.getValor()) {
            return -1;
        }
        return 1;
    }
}
