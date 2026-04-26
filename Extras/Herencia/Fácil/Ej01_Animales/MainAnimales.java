/**
 * Clase base que representa a un Animal genérico.
 */
class Animal {
    protected String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public void comer() {
        System.out.println(nombre + " está comiendo.");
    }
}

/**
 * Subclase Perro.
 */
class Perro extends Animal {
    public Perro(String nombre) {
        super(nombre); // Llama al constructor de Animal
    }

    public void ladrar() {
        System.out.println(nombre + " dice: ¡Guau guau!");
    }
}

/**
 * Subclase Gato.
 */
class Gato extends Animal {
    public Gato(String nombre) {
        super(nombre);
    }

    public void maullar() {
        System.out.println(nombre + " dice: ¡Miau miau!");
    }
}

public class MainAnimales {
    public static void main(String[] args) {
        Perro miPerro = new Perro("Fido");
        Gato miGato = new Gato("Pelusa");

        miPerro.comer();
        miPerro.ladrar();
        
        miGato.comer();
        miGato.maullar();
    }
}
