package Intermedio.Ej01_Buscador;

import java.util.Scanner;

/**
 * Clase principal que resuelve el ejercicio de Buscador de Elemento en Vector.
 * Implementa una búsqueda lineal básica sobre un arreglo de enteros de tamaño fijo.
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

        System.out.println("=== SISTEMA DE INVENTARIO ===");
        System.out.print("Cantidad de productos a registrar: ");
        int n = scan.nextInt();

        // Declaración e inicialización del vector (Memoria Estática)
        int[] inventario = new int[n];

        // Llenado del vector mediante un ciclo for
        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese código del producto " + (i + 1) + ": ");
            inventario[i] = scan.nextInt();
        }

        System.out.print("\nIngrese el código que desea buscar: ");
        int codigoBuscar = scan.nextInt();

        // Lógica de búsqueda lineal
        int posicionEncontrada = -1; // -1 indica que no ha sido encontrado
        boolean encontrado = false;  // Flag o bandera de control

        for (int i = 0; i < n; i++) {
            // Comparación del elemento actual con el valor buscado
            if (inventario[i] == codigoBuscar) {
                posicionEncontrada = i;
                encontrado = true;
                break; // Detenemos la búsqueda al encontrar la primera coincidencia
            }
        }

        // Mostrar resultados
        if (encontrado) {
            System.out.println("✅ Código encontrado exitosamente.");
            System.out.println("Ubicación en el sistema (índice): " + posicionEncontrada);
        } else {
            System.out.println("❌ Error: El código " + codigoBuscar + " no existe en el inventario.");
        }

        scan.close();
    }
}
