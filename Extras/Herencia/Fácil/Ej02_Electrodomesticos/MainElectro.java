/**
 * Clase base Electrodomestico.
 */
class Electrodomestico {
    protected String marca;
    protected char consumoEnergético;

    public Electrodomestico(String marca, char consumo) {
        this.marca = marca;
        this.consumoEnergético = consumo;
    }

    public void mostrarInfo() {
        System.out.println("Electrodoméstico: " + marca + " (Consumo: " + consumoEnergético + ")");
    }
}

/**
 * Subclase Lavadora que extiende Electrodomestico.
 */
class Lavadora extends Electrodomestico {
    private double carga;

    public Lavadora(String marca, char consumo, double carga) {
        super(marca, consumo);
        this.carga = carga;
    }

    public void mostrarCarga() {
        System.out.println("Capacidad de carga: " + carga + " kg");
    }
}

public class MainElectro {
    public static void main(String[] args) {
        Lavadora miLavadora = new Lavadora("LG", 'A', 15.0);
        miLavadora.mostrarInfo(); // Método heredado
        miLavadora.mostrarCarga(); // Método propio
    }
}
