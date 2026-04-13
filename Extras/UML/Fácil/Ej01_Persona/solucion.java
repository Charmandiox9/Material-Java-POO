package Fácil.Ej01_Persona;

/**
 * Clase que representa a una persona según el diagrama UML propuesto.
 * Este ejercicio demuestra la aplicación de visibilidad y el modelado de clases básicas.
 * 
 * @author Daniel Durán García
 * @version 1.0
 */
public class Persona {
    // - nombre : String
    private String nombre;

    // - edad : int
    private int edad;

    // - genero : char
    private char genero;

    /**
     * Constructor público de la clase Persona.
     * @param nombre El nombre completo de la persona.
     * @param edad La edad en años.
     * @param genero El género biográfico de la persona ('M', 'F', etc.).
     */
    public Persona(String nombre, int edad, char genero) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
    }

    /**
     * Obtiene el nombre de la persona.
     * @return El nombre actual.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece un nuevo nombre para la persona.
     * @param nombre El nuevo nombre a asignar.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la edad de la persona.
     * @return La edad en años.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece una nueva edad para la persona.
     * @param edad La nueva edad en años.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }
}
