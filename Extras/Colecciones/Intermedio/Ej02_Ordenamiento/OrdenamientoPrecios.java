import java.util.ArrayList;
import java.util.Collections;

public class OrdenamientoPrecios {
    public static void main(String[] args) {
        ArrayList<Double> precios = new ArrayList<>();
        precios.add(50.0);
        precios.add(10.0);
        precios.add(30.0);
        precios.add(5.0);
        precios.add(20.0);

        // Ordenar la lista in-place
        Collections.sort(precios);

        System.out.println("Precios ordenados: " + precios);
        System.out.println("Más barato: " + precios.get(0));
        System.out.println("Más caro: " + precios.get(precios.size() - 1));
    }
}
