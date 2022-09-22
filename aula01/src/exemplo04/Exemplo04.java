package exemplo04;

public class Exemplo04 {
    public static void main(String[] args) {
        int vetor[] = new int[9];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = i;
        }

        for (int i = vetor.length-1; i >= 0 ; i--) {
            System.out.print(vetor[i] + " ");
        }
    }
}
