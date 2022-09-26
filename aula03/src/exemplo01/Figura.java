package exemplo01;

public abstract class Figura {
    private int x, y;

    public Figura(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public abstract void exibir();
    public abstract String getName();
    public abstract void show(Imprimir imprimir);
}

