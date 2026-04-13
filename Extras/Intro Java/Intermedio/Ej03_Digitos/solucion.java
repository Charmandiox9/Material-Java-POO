package Intermedio.Ej03_Digitos;

import java.util.Scanner;

/**
 * Clase principal que resuelve el ejercicio de Descomposición de Dígitos.
 * Descompone un número entero en sus dígitos individuales usando operadores matemáticos.
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

        System.out.println("=== ANALIZADOR DE DÍGITOS ===");
        System.out.print("Ingrese un número entero positivo: ");
        int numeroOriginal = scan.nextInt();

        // 1. Determinar la cantidad de dígitos que tiene el número
        // Usamos una copia del número para no perder el original
        int temporal = numeroOriginal;
        int cantidadDigitos = 0;
        
        if (temporal == 0) {
            cantidadDigitos = 1;
        } else {
            while (temporal > 0) {
                temporal /= 10; // Elimina el último dígito
                cantidadDigitos++;
            }
        }

        // 2. Crear el vector para almacenar los dígitos
        int[] digitos = new int[cantidadDigitos];
        int sumaTotal = 0;

        // 3. Extraer los dígitos del último al primero
        temporal = numeroOriginal;
        for (int i = cantidadDigitos - 1; i >= 0; i--) {
            // El residuo (%) de 10 nos da el último dígito
            int digitoActual = temporal % 10;
            digitos[i] = digitoActual;
            sumaTotal += digitoActual; // Acumulación para la suma
            
            // Reducimos el número para la siguiente iteración
            temporal /= 10;
        }

        // 4. Mostrar resultados
        System.out.print("\nDígitos detectados: ");
        for (int i = 0; i < cantidadDigitos; i++) {
            System.out.print(digitos[i]);
            // Formato de separación
            if (i < cantidadDigitos - 1) {
                System.out.print(", ");
            }
        }
        
        System.out.println("\nSuma total: " + sumaTotal);

        scan.close();
    }
}
