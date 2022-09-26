package exemplo02;

import java.util.ArrayList;
import java.util.List;

public class AppPessoa {
    public static void main(String[] args) {
        List<Pessoa> lista = new ArrayList<>();

        lista.add(new Pessoa("Anderson"));
        lista.add(new Pessoa("Amanda"));
        lista.add(new Pessoa("Gustavo"));

        System.out.println(lista);

        System.out.println(lista.get(1));
    }
}
