package exemplo02;

public class Relogio {
    //atributos
    private int hora, minuto, segundo;

    public Relogio(int hora, int minuto, int segundo) {
        setHora(hora);
        setMinuto(minuto);
        this.segundo = segundo;
    }

    public void setHora(int novaHora) {
        if(novaHora >= 0 && novaHora < 24) {
            this.hora = novaHora;
        }
    }

    public void setMinuto(int novoMinuto) {
        if(novoMinuto >=0 && novoMinuto < 60) {
            minuto = novoMinuto;
        }
    }

    public int getMinuto() {
        return minuto;
    }

    // métodos = ações (função)
    // [retorno] nome ([parâmetros]) { }
    public void exibir() {
        System.out.println("Hora atual: " + hora + ":" +
                minuto + ":" + segundo);
    }
}
