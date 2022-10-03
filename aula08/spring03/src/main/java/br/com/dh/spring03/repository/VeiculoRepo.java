package br.com.dh.spring03.repository;

import br.com.dh.spring03.model.Veiculo;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
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

    public void saveVeiculo(Veiculo novoVeiculo) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        List<Veiculo> veiculos = getAll();

        veiculos = new ArrayList<>(veiculos);

        veiculos.add(novoVeiculo);

        try {
            writer.writeValue(new File(linkFile), veiculos);
        }catch (Exception ex) {
            System.out.println("Erro ao gravar o arquivo.");
        }
    }
}
