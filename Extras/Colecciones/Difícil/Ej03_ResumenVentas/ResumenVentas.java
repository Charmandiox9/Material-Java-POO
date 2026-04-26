import java.util.ArrayList;

class Venta {
    String producto;
    String categoria;
    double monto;

    public Venta(String p, String c, double m) {
        this.producto = p;
        this.categoria = c;
        this.monto = m;
    }
}

public class ResumenVentas {
    public static void main(String[] args) {
        ArrayList<Venta> ventas = new ArrayList<>();
        ventas.add(new Venta("Pan", "Alimento", 10.0));
        ventas.add(new Venta("Jabón", "Aseo", 5.0));
        ventas.add(new Venta("Leche", "Alimento", 12.0));

        ArrayList<String> categorias = new ArrayList<>();
        ArrayList<Double> totales = new ArrayList<>();

        for (Venta v : ventas) {
            int indice = categorias.indexOf(v.categoria);
            
            if (indice == -1) {
                // Nueva categoría detectada
                categorias.add(v.categoria);
                totales.add(v.monto);
            } else {
                // Categoría ya existe, actualizar total
                double nuevoTotal = totales.get(indice) + v.monto;
                totales.set(indice, nuevoTotal);
            }
        }

        System.out.println("Resumen de Ventas:");
        for (int i = 0; i < categorias.size(); i++) {
            System.out.println(categorias.get(i) + ": $" + totales.get(i));
        }
    }
}
