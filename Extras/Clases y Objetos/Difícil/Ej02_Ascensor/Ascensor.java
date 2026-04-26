/**
 * Clase que simula el funcionamiento de un Ascensor.
 */
public class Ascensor {
    
    private int pisoActual;
    private final int pisoMinimo;
    private final int pisoMaximo;
    private final int capacidadMax;
    private int personasActuales;
    private boolean puertasAbiertas;

    public Ascensor(int min, int max, int cap) {
        this.pisoMinimo = min;
        this.pisoMaximo = max;
        this.capacidadMax = cap;
        this.pisoActual = min;
        this.personasActuales = 0;
        this.puertasAbiertas = true;
    }

    public void subirPersonas(int cantidad) {
        if (personasActuales + cantidad <= capacidadMax) {
            personasActuales += cantidad;
            System.out.println("Subieron " + cantidad + " personas. Total: " + personasActuales);
        } else {
            System.out.println("Error: Capacidad excedida. No pueden subir.");
        }
    }

    public void moverAPiso(int destino) {
        if (destino < pisoMinimo || destino > pisoMaximo) {
            System.out.println("Error: El piso " + destino + " no existe.");
            return;
        }

        if (personasActuales > capacidadMax) {
            System.out.println("Error: Sobrepeso. El ascensor no se mueve.");
            return;
        }

        this.puertasAbiertas = false;
        System.out.println("Cerrando puertas... Moviendo del piso " + pisoActual + " al " + destino);
        this.pisoActual = destino;
        this.puertasAbiertas = true;
        System.out.println("Llegamos al piso " + pisoActual + ". Puertas abiertas.");
    }

    public static void main(String[] args) {
        Ascensor asc = new Ascensor(0, 10, 5);
        
        asc.subirPersonas(6); // Falla
        asc.subirPersonas(3); // Éxito
        asc.moverAPiso(12);   // Falla
        asc.moverAPiso(5);    // Éxito
    }
}
