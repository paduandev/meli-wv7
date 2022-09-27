package lambda;

public class MainLambda {

    interface InterfaceString {
        String executar(String str);
    }

    public static void main(String[] args) {
        InterfaceString novaString = s -> s + " terminação";

        imprimir("Original ", novaString);
    }

    public static void imprimir(String texto, InterfaceString interfaceString) {
        System.out.println(interfaceString.executar(texto));
    }

}
