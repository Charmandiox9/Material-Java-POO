/**
 * Clase que representa un Producto en un inventario.
 */
public class Producto {
    
    private String nombre;
    private double precio;
    private int stock;

    /**
     * Constructor de Producto.
     * @param nombre Nombre del artículo.
     * @param precio Precio unitario.
     * @param stock  Cantidad inicial.
     */
    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    /**
     * Incrementa el stock por una compra a proveedores.
     * @param cantidad Cantidad a sumar.
     */
    public void abastecer(int cantidad) {
        if (cantidad > 0) {
            this.stock += cantidad;
        }
    }

    /**
     * Reduce el stock por una venta.
     * @param cantidad Cantidad a restar.
     */
    public void vender(int cantidad) {
        if (cantidad > 0 && cantidad <= this.stock) {
            this.stock -= cantidad;
        } else {
            System.out.println("Error: Stock insuficiente para vender " + cantidad + " unidades.");
        }
    }

    /**
     * Muestra el resumen del producto.
     */
    public void mostrarEstado() {
        System.out.println("Producto: " + nombre + " | Stock Actual: " + stock + " unidades");
    }

    public static void main(String[] args) {
        // Creamos un producto inicial
        Producto miProducto = new Producto("Teclado", 25.0, 10);
        
        // Simulamos movimientos
        miProducto.vender(3);
        miProducto.abastecer(5);
        
        // Verificamos el resultado final
        miProducto.mostrarEstado();
    }
}
