package exemplo01;

public class Quadrado extends Figura {

    public Quadrado(int x, int y) {
        super(x, y);
    }

    @Override
    public void exibir() {
        System.out.println("Quadrado...");
    }

    @Override
    public String getName() {
        return "Quadrado";
    }

    @Override
    public void show(Imprimir imprimir) {
        imprimir.exibir("Quadrado");
    }


}
