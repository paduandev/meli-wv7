package br.com.dh.spring03.repository;

import br.com.dh.spring03.model.Veiculo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class VeiculoRepo {
    private final String linkFile = "src/main/resources/veiculos.json";
    ObjectMapper mapper = new ObjectMapper();

    public Optional<Veiculo> getVeiculo(String placa) {
        List<Veiculo> veiculos = null;
        try {
            veiculos = Arrays.asList(mapper.readValue(new File(linkFile), Veiculo[].class));
        }catch (Exception ex) {

        }
        for(Veiculo v: veiculos) {
            if(v.getPlaca().equals(placa)) {
                return Optional.of(v);
            }
        }
        return Optional.empty();
    }

    public List<Veiculo> getAll() {
        List<Veiculo> veiculos = null;
        try {
            veiculos = Arrays.asList(mapper.readValue(new File(linkFile), Veiculo[].class));
        }catch (Exception ex) {

        }
        return veiculos;
    }

}
