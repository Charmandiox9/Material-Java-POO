package Fácil.Ej03_Paridad;

import java.util.Scanner;

/**
 * Clase principal que resuelve el ejercicio de Análisis de Números.
 * Clasifica números ingresados por el usuario hasta que se ingrese un valor negativo.
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

        // Contadores inicializados en cero
        int pares = 0;
        int impares = 0;
        int ceros = 0;

        System.out.println("=== ANALIZADOR DE NÚMEROS ===");
        System.out.print("Ingrese un número entero (negativo para terminar): ");
        int numero = scan.nextInt();

        // Ciclo while: ideal cuando no conocemos el número exacto de iteraciones
        while (numero >= 0) {
            
            // Lógica de clasificación
            if (numero == 0) {
                // El cero se clasifica de forma independiente en este ejercicio
                ceros++;
            } else if (numero % 2 == 0) {
                // Si el residuo de la división por 2 es cero, el número es par
                pares++;
            } else {
                // En cualquier otro caso, el número es impar
                impares++;
            }

            // Captura del siguiente número para la siguiente iteración
            System.out.print("Ingrese el siguiente número: ");
            numero = scan.nextInt();
        }

        // Mostrar resumen estadístico
        System.out.println("\n=== RESUMEN ESTADÍSTICO ===");
        System.out.println("Cantidad de números pares: " + pares);
        System.out.println("Cantidad de números impares: " + impares);
        System.out.println("Cantidad de ceros encontrados: " + ceros);

        scan.close();
    }
}
