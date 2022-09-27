package generics;

import java.util.ArrayList;
import java.util.List;

public class AppGeneric {
    public static void main(String[] args) {
        MyClass<Integer> obj1 = new MyClass<>(222);
        MyClass<String> obj2 = new MyClass<>("Um texto");

        System.out.println(obj1.getObj());
        System.out.println(obj2.getObj());

        // uma possibilidade, pouco recomendada no caso geral
        List<?> lista = new ArrayList<>();
    }
}
