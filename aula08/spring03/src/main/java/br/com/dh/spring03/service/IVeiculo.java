package br.com.dh.spring03.service;

import br.com.dh.spring03.exception.VeiculoNotFoundException;
import br.com.dh.spring03.model.Veiculo;

import java.util.List;

public interface IVeiculo {
    Veiculo getVeiculo(String placa) throws VeiculoNotFoundException;
    List<Veiculo> getAllVeiculo();
}
