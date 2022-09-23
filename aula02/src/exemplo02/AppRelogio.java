package exemplo02;

public class AppRelogio {

    public static void main(String[] args) {
        Relogio meuRelogio = new Relogio(9,12, 0);
        Relogio outroRelogio = new Relogio(12, 72, 0);

        meuRelogio.exibir();
        outroRelogio.exibir();

        System.out.println("Minuto: " + meuRelogio.getMinuto());
        System.out.println("Minuto: " + outroRelogio.getMinuto());
    }
}
