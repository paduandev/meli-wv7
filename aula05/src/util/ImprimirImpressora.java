package util;

public class ImprimirImpressora implements Imprimir {
    @Override
    public void imprimir(String dados) {
        System.out.println("Exibindo dados na impressora...");
        System.out.println(dados);
    }
}
