package Difícil.Ej01_Composicion;

/**
 * Clase Celular que tiene una composición con Bateria.
 * En la composición, la parte (Bateria) es creada por el todo (Celular).
 */
class Celular {
    private String marca;
    private Bateria bateria;

    /**
     * Constructor del Celular. 
     * Implementa COMPOSICIÓN al instanciar la Bateria dentro del constructor.
     * @param marca La marca del equipo.
     * @param capacidadBateria La capacidad de la batería a crear.
     */
    public Celular(String marca, int capacidadBateria) {
        this.marca = marca;
        // La batería nace con el celular
        this.bateria = new Bateria(capacidadBateria);
    }
}

/**
 * Clase Bateria que es parte del Celular.
 */
class Bateria {
    private int capacidad;

    public Bateria(int capacidad) {
        this.capacidad = capacidad;
    }
}
