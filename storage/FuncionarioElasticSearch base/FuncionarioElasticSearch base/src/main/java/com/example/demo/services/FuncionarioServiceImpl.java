package com.example.demo.services;

import com.example.demo.domain.Funcionario;
import com.example.demo.elasticrepositories.FuncionarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository articuloRepository;

    @Override
    public Funcionario save(Funcionario funcionario) {
        return articuloRepository.save(funcionario
        );
    }
}
