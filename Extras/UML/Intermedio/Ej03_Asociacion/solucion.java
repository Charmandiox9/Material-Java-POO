package Intermedio.Ej03_Asociacion;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Profesor que tiene una asociación con Estudiante.
 */
class Profesor {
    private String nombre;

    // Relación 1 a muchos (List)
    private List<Estudiante> estudiantes;

    public Profesor(String nombre) {
        this.nombre = nombre;
        this.estudiantes = new ArrayList<>();
    }

    /**
     * Agrega un estudiante a la lista del profesor.
     * @param e El estudiante a agregar.
     */
    public void agregarEstudiante(Estudiante e) {
        this.estudiantes.add(e);
    }

    public void dictarClase() {
        System.out.println("El profesor " + nombre + " está dictando clase.");
    }
}

/**
 * Clase Estudiante asociada al Profesor.
 */
class Estudiante {
    private String nombre;
    private String RUT;

    public Estudiante(String nombre, String RUT) {
        this.nombre = nombre;
        this.RUT = RUT;
    }
}
