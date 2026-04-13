package Intermedio.Ej01_Herencia;

/**
 * Superclase abstracta Animal modelada en UML.
 * 
 * @author Daniel Durán García
 */
abstract class Animal {
    // # nombre : String (protegido)
    protected String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método abstracto que debe ser implementado por las subclases.
     */
    public abstract void hacerSonido();
}

/**
 * Subclase Perro que hereda de Animal.
 */
class Perro extends Animal {
    public Perro(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido() {
        System.out.println("Guau");
    }
}

/**
 * Subclase Gato que hereda de Animal.
 */
class Gato extends Animal {
    public Gato(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido() {
        System.out.println("Miau");
    }
}
