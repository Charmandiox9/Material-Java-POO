/**
 * Clase abstracta Edificio. Es la base del polimorfismo.
 */
abstract class Edificio {
    protected String nombre;
    protected double costoMantenimiento;
    protected int consumoEnergia;
    protected boolean encendido;

    public Edificio(String nombre, double costo, int energia) {
        this.nombre = nombre;
        this.costoMantenimiento = costo;
        this.consumoEnergia = energia;
        this.encendido = false;
    }

    // Obliga a las subclases a definir cómo generan ingresos
    public abstract double procesarTurno();

    public int getConsumoEnergia() { return consumoEnergia; }
    public double getCostoMantenimiento() { return costoMantenimiento; }
    public boolean isEncendido() { return encendido; }
    public void setEncendido(boolean estado) { this.encendido = estado; }
    public String getNombre() { return nombre; }
}

class EdificioResidencial extends Edificio {
    private int habitantes;

    public EdificioResidencial(String nombre, double costo, int energia, int habitantes) {
        super(nombre, costo, energia);
        this.habitantes = habitantes;
    }

    @Override
    public double procesarTurno() {
        if (!encendido) return 0.0;
        return habitantes * 10.0; // 10 dólares de impuesto por persona
    }
}

class EdificioComercial extends Edificio {
    private double ventasDiarias;

    public EdificioComercial(String nombre, double costo, int energia, double ventas) {
        super(nombre, costo, energia);
        this.ventasDiarias = ventas;
    }

    @Override
    public double procesarTurno() {
        if (!encendido) return 0.0;
        return ventasDiarias * 0.15; // 15% de impuestos sobre ventas
    }
}

class PlantaElectrica extends Edificio {
    public PlantaElectrica(String nombre, double costo, int produccion) {
        // La producción se representa como consumo negativo
        super(nombre, costo, -produccion);
    }

    @Override
    public double procesarTurno() {
        // Las plantas generan energía, no impuestos.
        return 0.0;
    }
}

class Ciudad {
    private Edificio[] edificios;
    private int numEdificios;
    private double presupuesto;
    private int dia;

    public Ciudad(double presupuestoInicial, int maxEdificios) {
        this.presupuesto = presupuestoInicial;
        this.edificios = new Edificio[maxEdificios];
        this.numEdificios = 0;
        this.dia = 1;
    }

    public void construir(Edificio e) {
        if (numEdificios < edificios.length) {
            edificios[numEdificios] = e;
            numEdificios++;
            System.out.println("Construido: " + e.getNombre());
        } else {
            System.out.println("Error: No hay espacio para más edificios.");
        }
    }

    public void avanzarDia() {
        System.out.println("\n=== INICIANDO DÍA " + dia + " ===");
        int energiaDisponible = 0;
        double ingresosHoy = 0.0;
        double gastosHoy = 0.0;

        // FASE 1: Producción de Energía
        for (int i = 0; i < numEdificios; i++) {
            if (edificios[i].getConsumoEnergia() < 0) { // Es una planta
                edificios[i].setEncendido(true);
                energiaDisponible += Math.abs(edificios[i].getConsumoEnergia());
            }
        }

        // FASE 2: Consumo de Energía
        for (int i = 0; i < numEdificios; i++) {
            Edificio e = edificios[i];
            if (e.getConsumoEnergia() > 0) {
                if (energiaDisponible >= e.getConsumoEnergia()) {
                    e.setEncendido(true);
                    energiaDisponible -= e.getConsumoEnergia();
                } else {
                    e.setEncendido(false);
                    System.out.println("⚠️ Apagón en: " + e.getNombre() + " (Falta de energía)");
                }
            }
        }

        // FASE 3: Finanzas (Polimorfismo en procesarTurno)
        for (int i = 0; i < numEdificios; i++) {
            Edificio e = edificios[i];
            if (e.isEncendido()) {
                // Pagar mantenimiento
                if (presupuesto >= e.getCostoMantenimiento()) {
                    presupuesto -= e.getCostoMantenimiento();
                    gastosHoy += e.getCostoMantenimiento();
                    
                    // Cobrar impuestos
                    double ingresos = e.procesarTurno();
                    presupuesto += ingresos;
                    ingresosHoy += ingresos;
                } else {
                    e.setEncendido(false);
                    System.out.println("💸 Quiebra parcial: " + e.getNombre() + " cerrado por falta de presupuesto de mantenimiento.");
                }
            }
        }

        System.out.println("Resumen del Día " + dia + ":");
        System.out.println("Energía Sobrante: " + energiaDisponible + " MW");
        System.out.println("Ingresos Totales: $" + ingresosHoy);
        System.out.println("Gastos Totales: $" + gastosHoy);
        System.out.println("Presupuesto Actual de la Ciudad: $" + presupuesto);
        dia++;
    }
}

public class SimuladorCiudad {
    public static void main(String[] args) {
        Ciudad miCiudad = new Ciudad(1500.0, 10);

        // Parámetros: Nombre, Costo Mantenimiento, Consumo Energía (o Prod.), [Atributo Propio]
        miCiudad.construir(new PlantaElectrica("Planta Carbón", 500.0, 100)); // Produce 100 MW
        miCiudad.construir(new EdificioResidencial("Barrio Centro", 100.0, 40, 50)); // Consume 40 MW, 50 hab.
        miCiudad.construir(new EdificioComercial("Mall", 300.0, 80, 5000.0)); // Consume 80 MW. 
        // Nota: 40 + 80 = 120 MW. La planta solo da 100. El Mall no tendrá energía.

        // Avanzamos 2 días para ver la lógica actuar
        miCiudad.avanzarDia();
        miCiudad.avanzarDia();
    }
}
