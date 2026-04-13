package Difícil.Ej03_TableroJuego;

import java.util.Scanner;

/**
 * Clase principal que resuelve el ejercicio de Lógica de Tablero 3x3 (Gato).
 * Implementa un juego de Tres en Línea simple con matrices y validaciones.
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
        
        // 1. Inicialización de la matriz de 3x3 (0 = vacío, 1 = J1, 2 = J2)
        int[][] tablero = new int[3][3];
        int turno = 1; // Empieza el Jugador 1
        boolean hayGanador = false;
        int jugadasTotal = 0;

        System.out.println("=== SIMULADOR DE TRES EN LÍNEA ===");

        // El juego continúa hasta que haya un ganador o se llenen las 9 casillas
        while (!hayGanador && jugadasTotal < 9) {
            mostrarTablero(tablero);
            
            System.out.println("\nTURNO JUGADOR " + turno);
            System.out.print("- Fila (0-2): ");
            int f = scan.nextInt();
            System.out.print("- Columna (0-2): ");
            int c = scan.nextInt();

            // 2. Validación de coordenadas y disponibilidad
            if (f >= 0 && f < 3 && c >= 0 && c < 3) {
                if (tablero[f][c] == 0) {
                    // Marcamos la jugada en la matriz
                    tablero[f][c] = turno;
                    jugadasTotal++;

                    // 3. Verificación de victoria (Filas y Columnas)
                    if (verificarGanador(tablero, turno)) {
                        hayGanador = true;
                        mostrarTablero(tablero);
                        System.out.println("\n🎉 ¡EL JUGADOR " + turno + " HA GANADO!");
                    } else {
                        // Cambio de turno (de 1 a 2, o de 2 a 1)
                        turno = (turno == 1) ? 2 : 1;
                    }

                } else {
                    System.out.println("❌ Error: Posición ya ocupada.");
                }
            } else {
                System.out.println("❌ Error: Coordenadas fuera de rango.");
            }
        }

        if (!hayGanador) {
            System.out.println("\n🤝 Empate. El tablero está lleno.");
        }

        scan.close();
    }

    /**
     * Imprime visualmente el estado actual de la matriz del tablero.
     * @param t Matriz de 3x3.
     */
    public static void mostrarTablero(int[][] t) {
        System.out.println("\nEstado actual:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("[" + t[i][j] + "]");
            }
            System.out.println();
        }
    }

    /**
     * Verifica si el jugador actual ha completado una fila o columna.
     * @param t El tablero.
     * @param j El número del jugador (1 o 2).
     * @return True si el jugador actual ganó, False en caso contrario.
     */
    public static boolean verificarGanador(int[][] t, int j) {
        for (int i = 0; i < 3; i++) {
            // Verificar Fila i
            if (t[i][0] == j && t[i][1] == j && t[i][2] == j) return true;
            // Verificar Columna i
            if (t[0][i] == j && t[1][i] == j && t[2][i] == j) return true;
        }
        return false;
    }
}
