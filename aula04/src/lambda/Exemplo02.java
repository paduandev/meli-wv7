package lambda;

import java.util.Arrays;
import java.util.List;

public class Exemplo02 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // aplicação de uma funçao anônima
        numeros.forEach( n -> {
                    System.out.print(n);
                    System.out.print(" - ");
                }
        );

        // faz a mesma coisa, usando uma instrução de repetição fori
        for (int i = 0; i < numeros.size(); i++) {
            System.out.print(numeros.get(i) + " ");
//            numeros.remove(i);
        }

        // faz a mesma coisa, usando uma instrução de repetição foreach
        for (Integer integer : numeros) {
            System.out.println(integer);
        }

    }
}
