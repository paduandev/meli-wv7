package exemplo01;

public class AppFiguras {

    public static void main(String[] args) {
//        Quadrado q = new Quadrado(1,2);

//        Figura f = new Quadrado(2,2);

        // não pode ser criado um objeto de uma classe abstrata
        // Figura f2 = new Figura(3,4);


        Figura vetorFigura[] = new Figura[3];

        vetorFigura[0] = new Quadrado(1,2);
        vetorFigura[1] = new Quadrado(2,2);
        vetorFigura[2] = new Circulo(3,4);

        for (int i = 0; i < 3; i++) {
            vetorFigura[i].exibir();
        }

        GerarPdf.gerar(vetorFigura[0]);
        GerarPdf.gerar(vetorFigura[2]);

        ExibirTela tela = new ExibirTela();

        vetorFigura[0].show(tela);
        vetorFigura[2].show(tela);

        ExibirImpressora ex = new ExibirImpressora();

        vetorFigura[0].show(ex);
        vetorFigura[2].show(ex);
    }
}
