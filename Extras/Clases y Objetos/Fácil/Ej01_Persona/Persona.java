/**
 * Clase que representa a una Persona.
 * Sigue los principios básicos de POO: atributos privados y métodos públicos.
 */
public class Persona {
    
    // Atributos privados: Encapsulamiento del estado
    private String nombre;
    private int edad;
    private String ciudad;

    /**
     * Constructor de la clase Persona.
     * @param nombre El nombre completo.
     * @param edad   La edad en años.
     * @param ciudad La ciudad de residencia.
     */
    public Persona(String nombre, int edad, String ciudad) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
    }

    /**
     * Muestra la ficha personal formateada.
     */
    public void mostrarFicha() {
        System.out.println("=== FICHA PERSONAL ===");
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Edad: " + this.edad + " años");
        System.out.println("Ciudad: " + this.ciudad);
    }

    /**
     * Punto de entrada para probar la clase.
     */
    public static void main(String[] args) {
        // Instanciación de un objeto
        Persona p1 = new Persona("Ana García", 25, "Madrid");
        
        // Llamada al método
        p1.mostrarFicha();
    }
}
