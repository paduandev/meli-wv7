package exemplo03;

public class Exemplo03 {
    public static void main(String[] args) {
        int contador = 1;

        while (contador <= 10) {
            System.out.print(contador + " ");
            // contador = contador + 1;
            // contador /= 3; // contador = contador / 3;
            contador++;
        }

        System.out.println();

        for (contador = 1; contador <= 10; contador++) {
            System.out.print(contador + " ");
        }

        for (int a = 1, b = 2;  a > 0  ; a--) {

        }

    }
}

