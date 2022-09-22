package exemplo01;


public class Exemplo01 {

    public static void main(String[] args) {
        // [TIPO] NOME;
        int numeroInteiro;
        double numeroDouble;

        numeroInteiro = 12;
        numeroDouble = 4.99999;

//        numeroDouble = numeroInteiro;
        numeroInteiro = (int) numeroDouble; // casting

        System.out.println("Resposta = " + numeroInteiro);
        System.out.println(numeroDouble);

        numeroDouble = (3 + 5) * 2;

        System.out.println(numeroDouble);
    }

}