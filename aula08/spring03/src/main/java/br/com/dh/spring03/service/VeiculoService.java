package br.com.dh.spring03.service;

import br.com.dh.spring03.model.Veiculo;
import br.com.dh.spring03.repository.VeiculoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService implements IVeiculo {

    @Autowired
    private VeiculoRepo repo;

    @Override
    public Veiculo getVeiculo(String placa) {
        return repo.getVeiculo(placa);
    }

    @Override
    public List<Veiculo> getAllVeiculo() {
        return null;
    }
}
