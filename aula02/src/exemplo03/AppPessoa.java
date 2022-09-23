package exemplo03;

public class AppPessoa {
    public static void main(String[] args) {
        Estudante estudante = new Estudante("Marcos Antônio");

        System.out.println(estudante.getNome());

        System.out.println(estudante);

        Pessoa p = new Estudante("João");

        System.out.println(p);

        Pessoa vetor[] = new Pessoa[10];

        vetor[0] = new Estudante("A");
        vetor[1] = new Diretor("D");
        vetor[2] = new Estudante("B");

        for (int i = 0; i < 3; i++) {
            System.out.println(vetor[i]);
        }
    }
}
