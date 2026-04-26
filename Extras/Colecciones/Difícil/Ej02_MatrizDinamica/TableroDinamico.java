import java.util.ArrayList;

public class TableroDinamico {
    public static void main(String[] args) {
        int filas = 3;
        int columnas = 3;

        // Crear la estructura
        ArrayList<ArrayList<Integer>> tablero = new ArrayList<>();

        // Inicializar
        for (int i = 0; i < filas; i++) {
            ArrayList<Integer> fila = new ArrayList<>();
            for (int j = 0; j < columnas; j++) {
                fila.add(0);
            }
            tablero.add(fila);
        }

        // Colocar valor en (1,1)
        tablero.get(1).set(1, 1);

        // Imprimir
        System.out.println("=== TABLERO ===");
        for (ArrayList<Integer> fila : tablero) {
            for (Integer celda : fila) {
                System.out.print(celda + " ");
            }
            System.out.println();
        }
    }
}
