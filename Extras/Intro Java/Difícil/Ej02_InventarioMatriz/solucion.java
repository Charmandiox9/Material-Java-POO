package Difícil.Ej02_InventarioMatriz;

import java.util.Scanner;

/**
 * Clase principal que resuelve el ejercicio de Inventario Avanzado con Matrices.
 * Gestiona una matriz de 2 columnas (ID, Stock) con operaciones dinámicas.
 * 
 * @author Daniel Durán García
 * @version 1.0
 */
public class solucion {

    /**
     * Punto de entrada de la aplicación.
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("=== SISTEMA DE INVENTARIO DISTRIBUIDO ===");
        System.out.print("Cantidad de productos diferentes a manejar: ");
        int n = scan.nextInt();

        // Matriz de n filas x 2 columnas (ID, STOCK)
        int[][] inventario = new int[n][2];

        // 1. Registro inicial de productos
        for (int i = 0; i < n; i++) {
            System.out.println("\nProducto " + (i + 1) + ":");
            System.out.print("- ID (Único): ");
            inventario[i][0] = scan.nextInt();
            System.out.print("- Stock Inicial: ");
            inventario[i][1] = scan.nextInt();
        }

        int opcion;
        do {
            System.out.println("\n--- MENÚ DE OPERACIONES ---");
            System.out.println("1. Vender Producto (Descontar Stock)");
            System.out.println("2. Abastecer Producto (Sumar Stock)");
            System.out.println("3. Ver Inventario Completo");
            System.out.println("0. Salir");
            System.out.print("Seleccione: ");
            opcion = scan.nextInt();

            switch (opcion) {
                case 1: // Venta
                    System.out.print("Ingrese ID del producto: ");
                    int idVenta = scan.nextInt();
                    int posVenta = buscarProducto(inventario, idVenta);

                    if (posVenta != -1) {
                        System.out.print("Cantidad a vender: ");
                        int cantVenta = scan.nextInt();
                        // Validación de disponibilidad
                        if (inventario[posVenta][1] >= cantVenta) {
                            inventario[posVenta][1] -= cantVenta;
                            System.out.println("✅ Venta realizada. Stock restante: " + inventario[posVenta][1]);
                        } else {
                            System.out.println("❌ Error: Stock insuficiente (Disponible: " + inventario[posVenta][1] + ")");
                        }
                    } else {
                        System.out.println("❌ Error: Producto no encontrado.");
                    }
                    break;

                case 2: // Abastecimiento
                    System.out.print("Ingrese ID del producto: ");
                    int idAbast = scan.nextInt();
                    int posAbast = buscarProducto(inventario, idAbast);

                    if (posAbast != -1) {
                        System.out.print("Cantidad a sumar: ");
                        int cantAbast = scan.nextInt();
                        inventario[posAbast][1] += cantAbast;
                        System.out.println("✅ Abastecimiento exitoso. Nuevo stock: " + inventario[posAbast][1]);
                    } else {
                        System.out.println("❌ Error: Producto no encontrado.");
                    }
                    break;

                case 3: // Listar
                    System.out.println("\n=== LISTADO DE INVENTARIO ===");
                    System.out.println("ID\tSTOCK");
                    for (int i = 0; i < inventario.length; i++) {
                        System.out.println(inventario[i][0] + "\t" + inventario[i][1]);
                    }
                    break;

                case 0:
                    System.out.println("Cerrando sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        scan.close();
    }

    /**
     * Realiza una búsqueda lineal en la matriz para encontrar la posición de un ID.
     * @param matriz El inventario a buscar.
     * @param id El código buscado.
     * @return El índice de la fila donde se encuentra el ID, o -1 si no existe.
     */
    public static int buscarProducto(int[][] matriz, int id) {
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][0] == id) {
                return i;
            }
        }
        return -1;
    }
}
