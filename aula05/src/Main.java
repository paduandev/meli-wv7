import data.DadosTeste;
import data.GerenciaClientes;
import data.GerenciaContas;
import exception.ContaInexistenteException;
import exception.DuplicatedCpfException;
import exception.InvalidNumberException;
import modelo.Cliente;
import util.Imprimir;
import util.ImprimirImpressora;
import util.ImprimirTela;

import java.util.Scanner;


public class Main {
    private static Scanner teclado = new Scanner(System.in);
    private static GerenciaContas contas = new GerenciaContas();
    private static GerenciaClientes clientes = new GerenciaClientes();

    public static void main(String[] args) {

        int opcaoMenuPrincipal, opcaoMenuCliente, opcaoMenuConta;

        // TODO: apenas para teste. Remover estas duas linhas na versão final
        clientes = DadosTeste.carregarDadosIniciaisClientes();
        contas = DadosTeste.carregarDadosIniciaisContas();

        do {
            System.out.println("1-Cliente");
            System.out.println("2-Contas");
            System.out.println("0-Sair");

            opcaoMenuPrincipal = Integer.parseInt(teclado.nextLine());

            switch (opcaoMenuPrincipal) {
                case 1:
                    System.out.println("1-Novo cliente");
                    System.out.println("2-Consultar cliente");
                    System.out.println("3-Remover cliente");
                    System.out.println("4-listar todos");
                    System.out.println("0-voltar");
                    System.out.print("Opção-> ");
                    opcaoMenuCliente = Integer.parseInt(teclado.nextLine());

                    atuarCliente(opcaoMenuCliente);

                    break;

                case 2:
                    System.out.println("1-Nova conta corrente");
                    System.out.println("2-Nova conta especial");
                    System.out.println("3-Nova conta poupança");
                    System.out.println("4-Realizar depósito");
                    System.out.println("5-Realizar saque");
                    System.out.println("6-Exibir saldo");
                    System.out.println("7-Remover conta");
                    System.out.println("8-Transferência entre contas");
                    System.out.println("9-Listar todas as contas");
                    System.out.println("10-Listar contas Corrente por Número");
                    System.out.println("11-Listar contas Corrente por Saldo");
                    System.out.println("12-Listar contas especial com Saldo Negativo");
                    System.out.println("0-Voltar");
                    System.out.print("Opção-> ");

                    opcaoMenuConta = Integer.parseInt(teclado.nextLine());

                    atuarConta(opcaoMenuConta);

                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;
            }

        } while (opcaoMenuPrincipal != 0);

        teclado.close();
    }

    private static void atuarCliente(int opcao) {
        String nome, cpf;
        Cliente cliente;

        switch (opcao) {
            case 1:
                System.out.print("Nome do cliente: ");
                nome = teclado.nextLine();
                System.out.print("CPF: ");
                cpf = teclado.nextLine();
                try {
                    clientes.novoCliente(nome, cpf);
                } catch (DuplicatedCpfException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                System.out.print("CPF: ");
                cpf = teclado.nextLine();
                cliente = clientes.obterCliente(cpf);
                if (cliente != null) {
                    System.out.println(cliente);
                } else {
                    System.out.println("Cliente não encontrado");
                }
                break;

            case 3:
                System.out.print("CPF: ");
                cpf = teclado.nextLine();
                if (contas.clientePossuiConta(cpf)) {
                    System.out.println("É necessário remover a conta deste cliente primeiro.");
                    break;
                }
                cliente = clientes.removerCliente(cpf);
                if (cliente != null) {
                    System.out.println("Removido: " + cliente);
                } else {
                    System.out.println("Cliente não encontrado");
                }
                break;

            case 4:
                System.out.println(clientes.listarTodos());
                break;

            case 0:
                break;

            default:
                System.out.println("Opção inválida");
                break;
        }

        System.out.println("Tecle ENTER para continuar.");
        teclado.nextLine();
    }

    private static void atuarConta(int opcao) {
        int numeroConta, numeroContaDestino;
        double limite, valor;
        String cpf;
        Cliente cliente;

        switch (opcao) {
            case 1:
                System.out.print("CPF: ");
                cpf = teclado.nextLine();
                cliente = clientes.obterCliente(cpf);
                if (cliente != null) {
                    contas.novaContaCorrente(cliente);
                } else {
                    System.out.println("Cliente não encontrado");
                }
                break;

            case 2:
                System.out.print("CPF: ");
                cpf = teclado.nextLine();
                cliente = clientes.obterCliente(cpf);
                if (cliente != null) {
                    System.out.println("Informe o valor do limite:");
                    limite = Double.parseDouble(teclado.nextLine());
                    contas.novaContaEspecial(cliente, limite);
                } else {
                    System.out.println("Cliente não encontrado");
                }
                break;

            case 3:
                System.out.print("CPF: ");
                cpf = teclado.nextLine();
                cliente = clientes.obterCliente(cpf);
                if (cliente != null) {
                    contas.novaContaPoupanca(cliente);
                } else {
                    System.out.println("Cliente não encontrado");
                }
                break;

            case 4:
                System.out.println("Digite o número da conta:");
                numeroConta = Integer.parseInt(teclado.nextLine());
                System.out.println("Digite o valor:");
                valor = Double.parseDouble(teclado.nextLine());
                try {
                    contas.depositar(numeroConta, valor);
                    System.out.println("operação realizada.");
                } catch (InvalidNumberException ex) {
                    System.out.println("operação não realizada. Valor inválido");
                } catch (ContaInexistenteException ex) {
                    System.out.println("operação não realizada. Conta inexistente");
                }
                break;

            case 5:
                System.out.println("Digite o número da conta:");
                numeroConta = Integer.parseInt(teclado.nextLine());
                System.out.println("Digite o valor:");
                valor = Double.parseDouble(teclado.nextLine());
                try {
                    if (contas.sacar(numeroConta, valor)) {
                        System.out.println("Saque realizado.");
                    } else {
                        System.out.println("Operação não realizada. Saldo insuficiente");
                    }
                } catch (InvalidNumberException ex) {
                    System.out.println("operação não realizada. Valor inválido");
                } catch (ContaInexistenteException ex) {
                    System.out.println("operação não realizada. Conta inexistente");
                }
                break;

            case 6:
                System.out.println("Digite o número da conta:");
                numeroConta = Integer.parseInt(teclado.nextLine());
                try {
                    System.out.println(contas.obterDadosConta(numeroConta));
                } catch (ContaInexistenteException ex) {
                    System.out.println("operação não realizada. Conta inexistente");
                }
                break;

            case 7:
                System.out.println("Digite o número da conta:");
                numeroConta = Integer.parseInt(teclado.nextLine());
                try {
                    contas.remover(numeroConta);
                    System.out.println("Conta removida.");
                } catch (ContaInexistenteException ex) {
                    System.out.println("operação não realizada. Conta inexistente");
                }
                break;

            case 8:
                System.out.println("Digite o número da conta de origem:");
                numeroConta = Integer.parseInt(teclado.nextLine());
                System.out.println("Digite o número da conta de destino:");
                numeroContaDestino = Integer.parseInt(teclado.nextLine());
                System.out.println("Digite o valor:");
                valor = Double.parseDouble(teclado.nextLine());
                try {
                    contas.transferir(numeroConta, numeroContaDestino, valor);
                } catch (InvalidNumberException ex) {
                    System.out.println("operação não realizada. Valor inválido");
                } catch (ContaInexistenteException ex) {
                    System.out.println("operação não realizada. Conta inexistente");
                }
                break;

            case 9:
                System.out.println("Tela ou Impressora (T/I)?");
                String saida = teclado.nextLine();
                if (saida.equalsIgnoreCase("I")) {
                    Imprimir imprimir = new ImprimirImpressora();
                    imprimir.imprimir(contas.listarTodasContas().toString());
                } else {
                    Imprimir imprimir = new ImprimirTela();
                    imprimir.imprimir(contas.listarTodasContas().toString());
                }
                break;

            case 10:
                System.out.println(contas.listarContaCorrentePorNumero());
                break;

            case 11:
                System.out.println(contas.listarContaCorrentePorSaldo());
                break;

            case 12:
                System.out.println(contas.listarContaEspecialNegativa());
                break;

            case 0:
                System.out.println("Finalizado.");
                break;

            default:
                System.out.println("Opção inválida");
                break;
        }

        System.out.println("Tecle ENTER para continuar.");
        teclado.nextLine();
    }

}
