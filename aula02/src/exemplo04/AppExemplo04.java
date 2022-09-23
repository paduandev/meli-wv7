package exemplo04;

public class AppExemplo04 {

    public static void main(String[] args) {
        Relogio r1 = new Relogio(1,1,1);
        Relogio r2 = new Relogio(2,2,2);

        Relogio.setMarca("Cassio");

        r1.exibir();
        r2.exibir();

        System.out.println(r1.show());
    }

}
