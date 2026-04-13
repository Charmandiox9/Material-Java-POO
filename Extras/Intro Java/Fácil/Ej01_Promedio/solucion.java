package Fácil.Ej01_Promedio;

import java.util.Scanner;

/**
 * Clase principal que resuelve el ejercicio de Sistema de Evaluación Académica.
 * El objetivo es calcular el promedio de notas y determinar el estado del alumno.
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
        // Objeto Scanner para capturar datos de la consola
        Scanner scan = new Scanner(System.in);

        // Variables de estado
        double sumaNotas = 0.0;
        int cantidadNotas = 0;

        System.out.println("=== SISTEMA DE CALIFICACIONES ===");
        System.out.print("Indique la cantidad de notas del alumno: ");
        
        // Captura inicial de la cantidad de notas
        cantidadNotas = scan.nextInt();

        // Estructura repetitiva para recolectar las notas individualmente
        for (int i = 1; i <= cantidadNotas; i++) {
            System.out.print("Ingrese la nota " + i + ": ");
            double notaActual = scan.nextDouble();
            
            // Acumulamos la nota para el cálculo posterior
            sumaNotas += notaActual;
        }

        // Cálculo del promedio (suma / cantidad)
        double promedio = sumaNotas / cantidadNotas;

        // Mostrar resultados con formato básico
        System.out.println("\n=== RESULTADO ACADÉMICO ===");
        System.out.println("Promedio Final: " + String.format("%.2f", promedio));

        // Estructura de decisión para determinar el estado académico
        if (promedio >= 4.0) {
            System.out.println("Estado: APROBADO");
        } else {
            System.out.println("Estado: REPROBADO");
        }

        // Cierre del recurso Scanner para evitar fugas de memoria
        scan.close();
    }
}
