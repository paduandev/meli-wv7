package br.com.dh.spring03.service;

import br.com.dh.spring03.model.Veiculo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService implements IVeiculo {
    @Override
    public Veiculo getVeiculo(String placa) {
        return new Veiculo(placa, "Astra", 2000, 12_000 );
    }

    @Override
    public List<Veiculo> getAllVeiculo() {
        return null;
    }
}
