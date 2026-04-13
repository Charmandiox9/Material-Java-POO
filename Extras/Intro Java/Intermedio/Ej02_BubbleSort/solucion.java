package Intermedio.Ej02_BubbleSort;

import java.util.Scanner;

/**
 * Clase principal que resuelve el ejercicio de Ordenamiento de Precios.
 * Implementa el algoritmo BubbleSort para ordenar un arreglo de tipos double.
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

        System.out.println("=== SISTEMA DE PRECIOS ===");
        System.out.print("Cantidad de precios a organizar: ");
        int n = scan.nextInt();

        // Arreglo para almacenar los precios
        double[] precios = new double[n];

        // Llenado de datos
        for (int i = 0; i < n; i++) {
            System.out.print("Precio " + (i + 1) + ": ");
            precios[i] = scan.nextDouble();
        }

        // --- Algoritmo de Ordenamiento BubbleSort ---
        // Se requieren dos ciclos anidados: 
        // El externo para pasar por todos los elementos
        for (int i = 0; i < n - 1; i++) {
            // El interno para realizar las comparaciones adyacentes
            for (int j = 0; j < n - i - 1; j++) {
                // Si el precio actual es mayor al siguiente, se intercambian (orden ascendente)
                if (precios[j] > precios[j + 1]) {
                    // Uso de variable auxiliar para el intercambio (Swap)
                    double temp = precios[j];
                    precios[j] = precios[j + 1];
                    precios[j + 1] = temp;
                }
            }
        }

        // Cálculo del mínimo y máximo (después de ordenar, están en los extremos)
        double minimo = precios[0];
        double maximo = precios[n - 1];

        // Mostrar resultados
        System.out.println("\n=== REPORTE DE PRECIOS ORDENADO ===");
        System.out.println("Precio Mínimo: " + minimo);
        System.out.println("Precio Máximo: " + maximo);

        System.out.println("\nLista ordenada:");
        for (int i = 0; i < n; i++) {
            System.out.print(precios[i]);
            // Formato para separar los valores con guiones
            if (i < n - 1) {
                System.out.print(" - ");
            }
        }
        System.out.println(); // Salto de línea final

        scan.close();
    }
}
