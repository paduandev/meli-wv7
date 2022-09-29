package data;

import exception.DuplicatedCpfException;
import modelo.Cliente;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GerenciaClientes {
    private Map<String, Cliente> clientes;

    public GerenciaClientes() {
        clientes = new HashMap<>();
    }

    public Cliente novoCliente(String nome, String cpf) throws DuplicatedCpfException {
        if (clientes.get(cpf) != null) {
            throw new DuplicatedCpfException("CPF já cadastrado.");
        }
        Cliente cliente = new Cliente(nome, cpf);
        clientes.put(cpf, cliente);
        return cliente;
    }

    public Cliente obterCliente(String cpf) {
        return clientes.get(cpf);
    }

    public Cliente removerCliente(String cpf) {
        return clientes.remove(cpf);

    }

    public List<String> listarTodos() {
        return clientes.values().stream()
                .map(c -> c.toString())
                .collect(Collectors.toList());
    }
}
