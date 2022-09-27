package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainStream {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 22, 13, 4, 56, 36, 75, 58, 19, 10);

        Stream<Integer> stream = numeros.stream();

        System.out.println("Exibindo todos os dados:");
//        stream.forEach(n -> System.out.print(n));
        stream.forEach(System.out::print);

        System.out.println("Números pares:");
        List<Integer> listaDePares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(listaDePares);

        System.out.println("Números ordenados:");
        numeros.stream()
                .sorted()
                .forEach(System.out::println);
    }
}
