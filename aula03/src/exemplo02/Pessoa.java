package exemplo02;

public class Pessoa {
    String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
