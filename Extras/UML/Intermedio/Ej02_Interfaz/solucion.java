package Intermedio.Ej02_Interfaz;

/**
 * Interfaz IVolador modelada en UML.
 */
interface IVolador {
    /**
     * Define el comportamiento de vuelo.
     */
    void volar();

    /**
     * Define el comportamiento de aterrizaje.
     */
    void aterrizar();
}

/**
 * Clase Pajaro que realiza la interfaz IVolador.
 */
class Pajaro implements IVolador {
    private String especie;

    public Pajaro(String especie) {
        this.especie = especie;
    }

    @Override
    public void volar() {
        System.out.println("El pájaro " + especie + " agita sus alas.");
    }

    @Override
    public void aterrizar() {
        System.out.println("El pájaro " + especie + " se posa en una rama.");
    }
}

/**
 * Clase Avion que realiza la interfaz IVolador.
 */
class Avion implements IVolador {
    private String modelo;

    public Avion(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public void volar() {
        System.out.println("El avión " + modelo + " enciende sus turbinas.");
    }

    @Override
    public void aterrizar() {
        System.out.println("El avión " + modelo + " despliega su tren de aterrizaje.");
    }
}
