package Difícil.Ej02_Agregacion;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Equipo que tiene una agregación con Jugadores.
 * En la agregación, las partes (Jugador) pueden existir sin el todo (Equipo).
 */
class Equipo {
    private String nombre;
    private List<Jugador> jugadores;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.jugadores = new ArrayList<>();
    }

    /**
     * Agrega un jugador al equipo.
     * Implementa AGREGACIÓN al recibir un objeto que ya ha sido creado afuera.
     * @param j El objeto Jugador ya instanciado.
     */
    public void agregarJugador(Jugador j) {
        this.jugadores.add(j);
    }
}

/**
 * Clase Jugador que puede existir independientemente.
 */
class Jugador {
    private String nombre;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }
}
