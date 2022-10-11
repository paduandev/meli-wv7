package br.com.dh.testes03.controller;

import br.com.dh.testes03.exception.ContaInexistenteException;
import br.com.dh.testes03.exception.InsufficientSaldoException;
import br.com.dh.testes03.exception.InvalidNumberException;
import br.com.dh.testes03.modelo.ContaCorrente;
import br.com.dh.testes03.service.ContaCorrenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cc")
public class ContaCorrenteController {

    @Autowired
    private ContaCorrenteService service;

    @GetMapping("/{numero}")
    public ResponseEntity<ContaCorrente> getConta(@PathVariable int numero) throws ContaInexistenteException {
        ContaCorrente cc = service.getConta(numero);

        return new ResponseEntity<>(cc, HttpStatus.OK);
    }

    @PostMapping("/{cliente}")
    public ResponseEntity<ContaCorrente> novaContaCorrente(@PathVariable String cliente) {
        ContaCorrente novaContaCorrete = service.novaContaCorrente(cliente);

        return new ResponseEntity<>(novaContaCorrete, HttpStatus.CREATED);
    }

    @PatchMapping("/dep/{numero}/{valor}")
    public ResponseEntity<ContaCorrente> depositar(@PathVariable int numero, @PathVariable double valor) throws ContaInexistenteException, InvalidNumberException {
        ContaCorrente cc = service.getConta(numero);
        service.depositar(numero, valor);
        return new ResponseEntity<>(cc, HttpStatus.OK);
    }

    @PatchMapping("/sacar/{numero}/{valor}")
    public ResponseEntity<ContaCorrente> sacar(@PathVariable int numero, @PathVariable double valor) throws ContaInexistenteException, InvalidNumberException, InsufficientSaldoException {
        ContaCorrente cc = service.getConta(numero);
        if(service.sacar(numero, valor)) {
            return new ResponseEntity<>(cc, HttpStatus.OK);
        }
        throw new InsufficientSaldoException("Saldo insuficiente");
    }


}
