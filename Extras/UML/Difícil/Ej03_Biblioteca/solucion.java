package Difícil.Ej03_Biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Biblioteca que implementa composición con Libro.
 */
class Biblioteca {
    private String nombre;
    private List<Libro> libros;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.libros = new ArrayList<>();
    }

    /**
     * Crea un libro dentro de la biblioteca (Composición).
     */
    public void registrarLibro(String t, String i) {
        Libro l = new Libro(t, i);
        this.libros.add(l);
    }
}

/**
 * Clase Libro que es parte de una Biblioteca y puede ser prestado por un Usuario.
 */
class Libro {
    private String titulo;
    private String ISBN;

    public Libro(String titulo, String ISBN) {
        this.titulo = titulo;
        this.ISBN = ISBN;
    }
}

/**
 * Clase Usuario que tiene una agregación restringida con Libro.
 */
class Usuario {
    private String nombre;
    private List<Libro> prestamos;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.prestamos = new ArrayList<>();
    }

    /**
     * Intenta pedir prestado un libro si no se ha superado el límite de 3.
     * @param l El libro a prestar.
     */
    public void prestar(Libro l) {
        if (this.prestamos.size() < 3) {
            this.prestamos.add(l);
        } else {
            System.out.println("❌ Límite de préstamos excedido para " + nombre);
        }
    }
}
