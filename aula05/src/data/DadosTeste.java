package data;

import exception.DuplicatedCpfException;

public class DadosTeste {
    private static GerenciaContas contas = new GerenciaContas();
    private static GerenciaClientes clientes = new GerenciaClientes();

    public static GerenciaClientes carregarDadosIniciaisClientes() {
        try {
            clientes.novoCliente("AAA", "1111");
            clientes.novoCliente("BBB", "2222");
            clientes.novoCliente("CCC", "3333");
            clientes.novoCliente("DDD", "4444");
            clientes.novoCliente("EEE", "5555");
            clientes.novoCliente("FFF", "6666");
            clientes.novoCliente("GGG", "7777");
        } catch (DuplicatedCpfException e) {
            e.printStackTrace();
        }

        return clientes;
    }

    public static GerenciaContas carregarDadosIniciaisContas() {
        contas.novaContaCorrente(clientes.obterCliente("1111"));
        contas.novaContaCorrente(clientes.obterCliente("2222"));
        contas.novaContaCorrente(clientes.obterCliente("3333"));
        contas.novaContaCorrente(clientes.obterCliente("4444"));
        contas.novaContaCorrente(clientes.obterCliente("5555"));
        contas.novaContaCorrente(clientes.obterCliente("6666"));
        contas.novaContaCorrente(clientes.obterCliente("7777"));

        return contas;
    }
}
