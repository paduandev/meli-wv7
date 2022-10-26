package com.example.demo.controllers;

import com.example.demo.domain.Funcionario;
import com.example.demo.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping("/funcionarios")
    public Funcionario save(@RequestBody Funcionario funcionario){
        return funcionarioService.save(funcionario);
    }

}
