import java.util.ArrayList;

public class BuscadorContactos {
    public static void main(String[] args) {
        ArrayList<String> contactos = new ArrayList<>();
        contactos.add("Ana");
        contactos.add("Pedro");
        contactos.add("Luis");

        String buscar = "Pedro";

        if (contactos.contains(buscar)) {
            int posicion = contactos.indexOf(buscar);
            System.out.println("El contacto '" + buscar + "' fue encontrado en la posición " + posicion + ".");
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }
}
