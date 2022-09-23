package exemplo07;

import java.util.Scanner;

public class Exemplo07 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numero;
        String nome;
        String dadoDigitado;



        System.out.println("Digite um número inteiro:");
        numero = entrada.nextInt();
//        dadoDigitado = entrada.nextLine();
//        numero = Integer.parseInt(dadoDigitado);

        System.out.println("Digite o seu nome:");
        nome = entrada.nextLine();

        System.out.println("Vc digitou: " + numero);
        System.out.println("Vc digitou: " + nome);

        entrada.close();
    }
}
