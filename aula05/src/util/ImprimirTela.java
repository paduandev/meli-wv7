package util;

public class ImprimirTela implements Imprimir {

    @Override
    public void imprimir(String dados) {
        System.out.println("Exibindo na tela...");
        System.out.println(dados);
    }
}
