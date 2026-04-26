import java.util.ArrayList;

public class CalculadoraGastos {
    public static void main(String[] args) {
        ArrayList<Double> precios = new ArrayList<>();
        precios.add(15.50);
        precios.add(42.00);
        precios.add(10.25);

        double total = 0;

        for (Double precio : precios) {
            total += precio;
        }

        System.out.println("Total de productos: " + precios.size());
        System.out.println("Costo Total: $" + total);
    }
}
