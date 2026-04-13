package Difícil.Ej01_NotasMatriz;

import java.util.Scanner;

/**
 * Clase principal que resuelve el ejercicio de Gestión de Notas por Asignatura.
 * Implementa el uso de matrices para cálculos estadísticos bidimensionales.
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

        System.out.println("=== SISTEMA ACADÉMICO AVANZADO ===");
        System.out.print("Cantidad de alumnos: ");
        int cantAlumnos = scan.nextInt();
        System.out.print("Cantidad de asignaturas: ");
        int cantAsignaturas = scan.nextInt();

        // 1. Declaración e inicialización de la matriz
        double[][] notas = new double[cantAlumnos][cantAsignaturas];
        double notaMaxima = 0.0;

        // 2. Llenado de la matriz (Recorrido por Filas)
        for (int i = 0; i < cantAlumnos; i++) {
            System.out.println("\nNotas Alumno " + (i + 1) + ":");
            for (int j = 0; j < cantAsignaturas; j++) {
                System.out.print("- Asignatura " + (j + 1) + ": ");
                notas[i][j] = scan.nextDouble();

                // Búsqueda de la nota máxima global
                if (notas[i][j] > notaMaxima) {
                    notaMaxima = notas[i][j];
                }
            }
        }

        System.out.println("\n=== RESULTADOS DEL REPORTE ===");

        // 3. Promedio por Alumno (Recorrido por Fila)
        for (int i = 0; i < cantAlumnos; i++) {
            double sumaFila = 0;
            for (int j = 0; j < cantAsignaturas; j++) {
                sumaFila += notas[i][j];
            }
            double promedioAlumno = sumaFila / cantAsignaturas;
            System.out.println("Promedio Alumno " + (i + 1) + ": " + String.format("%.2f", promedioAlumno));
        }

        // 4. Promedio por Asignatura (Recorrido por Columna)
        for (int j = 0; j < cantAsignaturas; j++) {
            double sumaColumna = 0;
            for (int i = 0; i < cantAlumnos; i++) {
                sumaColumna += notas[i][j];
            }
            double promedioAsignatura = sumaColumna / cantAlumnos;
            System.out.println("Promedio Asignatura " + (j + 1) + ": " + String.format("%.2f", promedioAsignatura));
        }

        // 5. Mostrar la nota máxima global
        System.out.println("\nNota Máxima del Curso: " + notaMaxima);

        scan.close();
    }
}
