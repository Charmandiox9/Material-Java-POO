package Integrador.Ej_SistemaVentas;

import java.util.ArrayList;
import java.util.List;

/**
 * Interfaz que define el contrato del sistema de ventas.
 */
interface ISistemaVentas {
    void procesarPedido(Pedido p);
}

/**
 * Implementación del sistema de ventas.
 */
class VentasImpl implements ISistemaVentas {
    private List<Pedido> pedidos;

    public VentasImpl() {
        this.pedidos = new ArrayList<>();
    }

    @Override
    public void procesarPedido(Pedido p) {
        this.pedidos.add(p);
        System.out.println("✅ Pedido " + p.getID() + " procesado.");
    }
}

/**
 * Clase que representa un pedido en el sistema.
 */
class Pedido {
    private int ID;
    private String fecha;
    private List<DetallePedido> detalles;

    public Pedido(int ID, String fecha) {
        this.ID = ID;
        this.fecha = fecha;
        this.detalles = new ArrayList<>();
    }

    public void agregarDetalle(Producto prod, int cant, double precio) {
        this.detalles.add(new DetallePedido(prod, cant, precio));
    }

    public int getID() { return ID; }
}

/**
 * Clase de detalle del pedido (Composición con Pedido).
 */
class DetallePedido {
    private int cantidad;
    private double precioUnitario;
    private Producto producto; // Asociación con Producto

    public DetallePedido(Producto p, int c, double pu) {
        this.producto = p;
        this.cantidad = c;
        this.precioUnitario = pu;
    }
}

/**
 * Clase abstracta que define un producto genérico.
 */
abstract class Producto {
    protected String nombre;

    public Producto(String nombre) {
        this.nombre = nombre;
    }
}

/**
 * Subclase para productos físicos.
 */
class ProductoFisico extends Producto {
    private double peso;

    public ProductoFisico(String nombre, double peso) {
        super(nombre);
        this.peso = peso;
    }
}

/**
 * Subclase para productos digitales.
 */
class ProductoDigital extends Producto {
    private String enlaceDescarga;

    public ProductoDigital(String nombre, String enlace) {
        super(nombre);
        this.enlaceDescarga = enlace;
    }
}

/**
 * Clase App que coordina el sistema.
 */
public class App {
    public static void main(String[] args) {
        // [⚠️ IMPORTANTE]: Uso de interfaz para el sistema
        ISistemaVentas sistema = new VentasImpl();

        // Creación de datos de prueba
        Producto p1 = new ProductoFisico("Laptop", 2.5);
        Producto p2 = new ProductoDigital("E-book POO", "http://descarga.com");

        Pedido ped = new Pedido(1, "2026-04-13");
        ped.agregarDetalle(p1, 1, 800000);
        ped.agregarDetalle(p2, 1, 15000);

        // Procesamiento mediante la interfaz
        sistema.procesarPedido(ped);
    }
}
