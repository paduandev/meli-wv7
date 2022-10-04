package br.com.dh.spring03.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Proprietario {
    private int id;
    private String nome;
    private String telefone;
    private List<Veiculo> veiculos;

    public void addVeiculo(Veiculo veiculo) {
        if(veiculos == null) {
            veiculos = new ArrayList<>();
        }
        veiculos.add(veiculo);
    }

}
