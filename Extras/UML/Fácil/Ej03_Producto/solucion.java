package Fácil.Ej03_Producto;

/**
 * Clase que representa a un producto con constantes modeladas en UML.
 * Este ejercicio demuestra el modelado de constantes y métodos de cálculo.
 * 
 * @author Daniel Durán García
 * @version 1.0
 */
public class Producto {
    // + IVA : double = 0.19 $ (representado como static final en Java)
    public static final double IVA = 0.19;

    // - nombre : String
    private String nombre;

    // - precioBase : double
    private double precioBase;

    /**
     * Constructor público para inicializar el producto.
     * @param nombre El nombre comercial del producto.
     * @param precio El precio neto antes de impuestos.
     */
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precioBase = (precio >= 0) ? precio : 0;
    }

    /**
     * Calcula el precio final del producto sumando el IVA al precio base.
     * @return El precio total con impuestos incluidos.
     */
    public double calcularPrecioFinal() {
        return this.precioBase + (this.precioBase * IVA);
    }
}
