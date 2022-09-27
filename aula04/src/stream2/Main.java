package stream2;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Pessoa> pessoas = Dados.getPessoas();

        pessoas.stream()
                .filter(p->p.getPais().equalsIgnoreCase("Brazil"))
                .limit(10)
                .forEach(System.out::println);

        System.out.println("Ordenado:");
        pessoas.stream()
                .filter(p->p.getPais().equalsIgnoreCase("Brazil"))
                .limit(10)
                .sorted()
                .forEach(System.out::println);


        System.out.println("Ordenado por nome:");
        pessoas.stream()
                .filter(p->p.getPais().equalsIgnoreCase("Brazil"))
                .limit(10)
                .sorted((p1, p2)-> p1.getNome().compareTo(p2.getNome()))
                .forEach(System.out::println);

        double mediaIdade = pessoas.stream()
                .mapToDouble(p->p.getIdade())
                .average().getAsDouble();

        System.out.println("Média de idade: " + mediaIdade);
    }
}
