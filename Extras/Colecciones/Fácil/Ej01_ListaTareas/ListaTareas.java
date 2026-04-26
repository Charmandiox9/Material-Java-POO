import java.util.ArrayList;
import java.util.List;

/**
 * Gestión básica de una lista de Strings.
 */
public class ListaTareas {
    public static void main(String[] args) {
        // Declaración usando la interfaz List y la implementación ArrayList
        List<String> tareas = new ArrayList<>();

        // Agregando elementos
        tareas.add("Estudiar POO");
        tareas.add("Comprar café");
        tareas.add("Lavar ropa");

        // Recorrido y visualización
        System.out.println("=== MIS TAREAS ===");
        for (int i = 0; i < tareas.size(); i++) {
            System.out.println((i + 1) + ". " + tareas.get(i));
        }
    }
}
