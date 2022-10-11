package br.com.dh.testes03.controller;

import br.com.dh.testes03.dto.TransfDTO;
import br.com.dh.testes03.exception.ContaInexistenteException;
import br.com.dh.testes03.exception.InvalidNumberException;
import br.com.dh.testes03.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("contas/")
public class ContaController {

    @Autowired
    private ContaService service;

    @PostMapping("/transf/{origem}/{destino}/{valor}")
    public ResponseEntity<TransfDTO> transferencia(@PathVariable int origem,
                                                   @PathVariable int destino,
                                                   @PathVariable double valor) throws ContaInexistenteException, InvalidNumberException {
        TransfDTO transfDTO = service.transferir(origem, destino, valor);

        return new ResponseEntity<>(transfDTO, HttpStatus.OK);
    }

}
