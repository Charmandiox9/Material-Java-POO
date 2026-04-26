import java.util.ArrayList;

public class DepuracionInvitados {
    public static void main(String[] args) {
        ArrayList<String> original = new ArrayList<>();
        original.add("Ana");
        original.add("Pedro");
        original.add("Ana");
        original.add("Luis");
        original.add("Pedro");

        ArrayList<String> unicos = new ArrayList<>();

        for (String nombre : original) {
            // Solo agregamos si no existe ya en la lista de únicos
            if (!unicos.contains(nombre)) {
                unicos.add(nombre);
            }
        }

        System.out.println("Original: " + original);
        System.out.println("Lista depurada: " + unicos);
    }
}
