package exemplo01;

public class Circulo extends Figura {

    public Circulo(int x, int y) {
        super(x, y);
    }

    @Override
    public void exibir() {
        System.out.println("Circulo");
    }

    @Override
    public String getName() {
        return "Circulo";
    }

    @Override
    public void show(Imprimir imprimir) {
        imprimir.exibir("Circulo");
    }
}
