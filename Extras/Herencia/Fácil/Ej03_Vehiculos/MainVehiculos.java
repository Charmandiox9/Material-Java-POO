/**
 * Clase base Vehiculo.
 */
class Vehiculo {
    protected double velocidadMaxima;

    public Vehiculo(double vel) {
        this.velocidadMaxima = vel;
    }
}

/**
 * Subclase Coche.
 */
class Coche extends Vehiculo {
    private int puertas;

    public Coche(double vel, int puertas) {
        super(vel);
        this.puertas = puertas;
    }

    public void mostrarCoche() {
        System.out.println("Vehículo a " + velocidadMaxima + " km/h con " + puertas + " puertas.");
    }
}

/**
 * Subclase Bicicleta.
 */
class Bicicleta extends Vehiculo {
    private String tipo;

    public Bicicleta(double vel, String tipo) {
        super(vel);
        this.tipo = tipo;
    }

    public void mostrarBici() {
        System.out.println("Bicicleta de " + tipo + " a " + velocidadMaxima + " km/h.");
    }
}

public class MainVehiculos {
    public static void main(String[] args) {
        Coche c = new Coche(180, 5);
        Bicicleta b = new Bicicleta(40, "Montaña");

        c.mostrarCoche();
        b.mostrarBici();
    }
}
