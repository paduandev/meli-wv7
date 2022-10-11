package br.com.dh.testes03.service;

import br.com.dh.testes03.dao.ContaDAO;
import br.com.dh.testes03.dto.TransfDTO;
import br.com.dh.testes03.exception.ContaInexistenteException;
import br.com.dh.testes03.exception.InvalidNumberException;
import br.com.dh.testes03.modelo.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

    @Autowired
    private ContaDAO dao;

    public TransfDTO transferir(int numeroContaOrigem, int numeroContaDestino, double valor) throws ContaInexistenteException, InvalidNumberException {
        Conta contaOrigem = dao.getConta(numeroContaOrigem);
        Conta contaDestino = dao.getConta(numeroContaDestino);

        boolean saqueRealizado = contaOrigem.sacar(valor);

        if(saqueRealizado) {
            contaDestino.depositar(valor);
        }

        dao.updateConta(contaOrigem);
        dao.updateConta(contaDestino);

        return new TransfDTO(contaOrigem, contaDestino);
    }
}
