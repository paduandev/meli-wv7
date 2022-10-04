package br.com.dh.spring03.repository;

import br.com.dh.spring03.model.Proprietario;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProprietarioRepo {
    private String linkFile = "src/main/resources/prorprietario.json";

    public List<Proprietario> getAll() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return Arrays.asList(mapper.readValue(new File(linkFile), Proprietario[].class));
        }catch (Exception ex) {
            System.out.println("Erro ao ler o arquivo.");
        }
        return null;
    }

}
