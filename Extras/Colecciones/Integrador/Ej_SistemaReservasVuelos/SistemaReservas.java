import java.util.ArrayList;
import java.util.List;

class Pasajero {
    private String nombre;
    private String pasaporte;

    public Pasajero(String nombre, String pasaporte) {
        this.nombre = nombre;
        this.pasaporte = pasaporte;
    }

    public String getPasaporte() { return pasaporte; }
    public String getNombre() { return nombre; }
}

class Vuelo {
    private String codigo;
    private String destino;
    private int capacidad;
    private double precio;
    private List<Pasajero> pasajeros;

    public Vuelo(String codigo, String destino, int capacidad, double precio) {
        this.codigo = codigo;
        this.destino = destino;
        this.capacidad = capacidad;
        this.precio = precio;
        this.pasajeros = new ArrayList<>();
    }

    public boolean reservar(Pasajero p) {
        if (pasajeros.size() < capacidad) {
            pasajeros.add(p);
            return true;
        }
        return false;
    }

    public void cancelar(String pasaporte) {
        for (int i = 0; i < pasajeros.size(); i++) {
            if (pasajeros.get(i).getPasaporte().equals(pasaporte)) {
                pasajeros.remove(i);
                System.out.println("Reserva cancelada para pasaporte: " + pasaporte);
                return;
            }
        }
    }

    public double calcularIngresos() {
        return pasajeros.size() * precio;
    }

    public double getOcupacion() {
        return ((double) pasajeros.size() / capacidad) * 100;
    }

    public boolean tienePasajero(String pasaporte) {
        for (Pasajero p : pasajeros) {
            if (p.getPasaporte().equals(pasaporte)) return true;
        }
        return false;
    }

    public String getCodigo() { return codigo; }
    public String getDestino() { return destino; }
}

class Aerolinea {
    private List<Vuelo> vuelos;

    public Aerolinea() {
        this.vuelos = new ArrayList<>();
    }

    public void agregarVuelo(Vuelo v) {
        vuelos.add(v);
    }

    public void buscarPasajero(String pasaporte) {
        boolean encontrado = false;
        for (Vuelo v : vuelos) {
            if (v.tienePasajero(pasaporte)) {
                System.out.println("Pasajero " + pasaporte + " encontrado en: Vuelo " + v.getCodigo() + " hacia " + v.getDestino());
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("Pasajero no registrado en ningún vuelo.");
    }

    public void vueloMasRentable() {
        if (vuelos.isEmpty()) return;
        
        Vuelo rentable = vuelos.get(0);
        for (Vuelo v : vuelos) {
            if (v.calcularIngresos() > rentable.calcularIngresos()) {
                rentable = v;
            }
        }
        System.out.println("El vuelo más rentable es: " + rentable.getCodigo() + " ($" + rentable.calcularIngresos() + ")");
    }

    public void generarReporte() {
        System.out.println("\n=== REPORTE DE OCUPACIÓN ===");
        for (Vuelo v : vuelos) {
            System.out.printf("Vuelo: %s | Destino: %s | Ocupación: %.1f%%\n", 
                v.getCodigo(), v.getDestino(), v.getOcupacion());
        }
    }
}

public class SistemaReservas {
    public static void main(String[] args) {
        Aerolinea lan = new Aerolinea();

        Vuelo v1 = new Vuelo("SCL-101", "Santiago", 4, 500.0);
        Vuelo v2 = new Vuelo("LIM-202", "Lima", 5, 300.0);

        lan.agregarVuelo(v1);
        lan.agregarVuelo(v2);

        // Pasajeros
        v1.reservar(new Pasajero("Ana", "P123"));
        v1.reservar(new Pasajero("Pedro", "P456"));
        v1.reservar(new Pasajero("Luis", "P789"));
        
        v2.reservar(new Pasajero("Marta", "P999"));
        v2.reservar(new Pasajero("Ana", "P123")); // Ana viaja a ambos lugares

        lan.generarReporte();
        lan.buscarPasajero("P123");
        lan.vueloMasRentable();
    }
}
