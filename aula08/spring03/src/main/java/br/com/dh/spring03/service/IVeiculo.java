package br.com.dh.spring03.service;

import br.com.dh.spring03.dto.VeiculoDTO;
import br.com.dh.spring03.exception.NotFoundException;
import br.com.dh.spring03.model.Veiculo;

import java.util.List;

public interface IVeiculo {
    Veiculo getVeiculo(String placa) throws NotFoundException;
    List<VeiculoDTO> getAllVeiculo();
    List<Veiculo> getAllOrderByValue();
    void save(Veiculo veiculo);
    List<Veiculo> getByModel(String model);
}
