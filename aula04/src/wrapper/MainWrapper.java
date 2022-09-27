package wrapper;

public class MainWrapper {
    public static void main(String[] args) {
        int n = 10;
        Integer integer = 15; // autoboxing: boxing

        n = integer; // autoboxing: unboxing

        System.out.println(n);
        System.out.println(integer);

        int valor = Integer.parseInt("123");

        String texto = 123 + ""; // Integer.toString(123);

        Integer n1 = 200;
        Integer n2 = 200;

        System.out.println(n1 == n2);
        System.out.println(n1.equals(n2));
    }

}
