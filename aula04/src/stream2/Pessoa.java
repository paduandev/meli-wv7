package stream2;

public class Pessoa implements Comparable<Pessoa>{
    private String nome, pais;
    private int idade;
    private double valorGasto;

    public Pessoa(String nome, String pais, int idade, double valorGasto) {
        this.nome = nome;
        this.pais = pais;
        this.idade = idade;
        this.valorGasto = valorGasto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getValorGasto() {
        return valorGasto;
    }

    public void setValorGasto(double valorGasto) {
        this.valorGasto = valorGasto;
    }

    @Override
    public String toString() {
        return this.nome + ": " + idade + ": " + pais;
    }

    @Override
    public int compareTo(Pessoa outraPessoa) {
        if(this.idade < outraPessoa.getIdade()){
            return -1;
        }
        if(this.idade > outraPessoa.getIdade()){
            return 1;
        }
        return 0;
    }
}
