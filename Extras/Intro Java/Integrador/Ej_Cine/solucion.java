package Integrador.Ej_Cine;

import java.util.Scanner;

/**
 * Clase principal que resuelve el Ejercicio Integrador de Introducción a Java.
 * Simula un sistema de gestión de asientos y cobros para una sala de cine.
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

        // 1. Matriz de la sala de cine (5x5). 'L' = Libre, 'X' = Ocupado
        char[][] sala = new char[5][5];
        
        // Inicializar la matriz con todos los asientos 'L' (Libres)
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                sala[i][j] = 'L';
            }
        }

        // 2. Vector de precios de los diferentes tipos de entradas
        double[] precios = {5000.0, 3500.0, 3000.0};

        // 3. Variables de acumulación (Estado global del sistema)
        double recaudacionTotal = 0.0;
        int asientosOcupados = 0;

        int opcion;

        // 4. Ciclo principal del Menú (do-while)
        do {
            System.out.println("\n=== SISTEMA DE GESTIÓN DE CINE ===");
            System.out.println("1. Mostrar Estado de la Sala");
            System.out.println("2. Reservar Asiento (Comprar)");
            System.out.println("3. Cancelar Reserva (Liberar)");
            System.out.println("4. Resumen de Ventas");
            System.out.println("0. Salir del Sistema");
            System.out.print("Seleccione una opción: ");
            opcion = scan.nextInt();

            // 5. Estructura de decisión múltiple (switch)
            switch (opcion) {
                
                case 1: // Mostrar la Sala
                    System.out.println("\n--- PANTALLA ---");
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {
                            System.out.print("[" + sala[i][j] + "] ");
                        }
                        System.out.println(); // Salto de línea por cada fila
                    }
                    break;

                case 2: // Reservar (Comprar)
                    System.out.print("\nIngrese Fila (0-4): ");
                    int filaReserva = scan.nextInt();
                    System.out.print("Ingrese Columna (0-4): ");
                    int colReserva = scan.nextInt();

                    // Validación de límites (Evitar ArrayIndexOutOfBoundsException)
                    if (filaReserva >= 0 && filaReserva < 5 && colReserva >= 0 && colReserva < 5) {
                        
                        // Validación de estado del asiento
                        if (sala[filaReserva][colReserva] == 'L') {
                            
                            System.out.println("Tipos de Entrada:");
                            System.out.println("0: General ($5000) | 1: Estudiante ($3500) | 2: 3ra Edad ($3000)");
                            System.out.print("Seleccione tarifa (0-2): ");
                            int tipoTarifa = scan.nextInt();

                            // Validación del vector de precios
                            if (tipoTarifa >= 0 && tipoTarifa < 3) {
                                sala[filaReserva][colReserva] = 'X'; // Marcar como ocupado
                                recaudacionTotal += precios[tipoTarifa]; // Acumular dinero
                                asientosOcupados++;
                                System.out.println("✅ Reserva exitosa. Se han cobrado $" + precios[tipoTarifa]);
                            } else {
                                System.out.println("❌ Error: Tarifa no válida.");
                            }

                        } else {
                            System.out.println("❌ Error: El asiento ya está ocupado.");
                        }
                    } else {
                        System.out.println("❌ Error: Las coordenadas están fuera del límite de la sala.");
                    }
                    break;

                case 3: // Cancelar (Liberar)
                    System.out.print("\nIngrese Fila a cancelar (0-4): ");
                    int filaCancela = scan.nextInt();
                    System.out.print("Ingrese Columna a cancelar (0-4): ");
                    int colCancela = scan.nextInt();

                    // Validación de límites
                    if (filaCancela >= 0 && filaCancela < 5 && colCancela >= 0 && colCancela < 5) {
                        
                        // Validación de estado
                        if (sala[filaCancela][colCancela] == 'X') {
                            sala[filaCancela][colCancela] = 'L'; // Volver a marcar como libre
                            asientosOcupados--;
                            System.out.println("✅ Reserva cancelada. Asiento liberado.");
                        } else {
                            System.out.println("❌ Error: El asiento ya está libre, no se puede cancelar.");
                        }

                    } else {
                        System.out.println("❌ Error: Las coordenadas están fuera del límite de la sala.");
                    }
                    break;

                case 4: // Resumen Estadístico
                    System.out.println("\n=== RESUMEN FINANCIERO Y DE OCUPACIÓN ===");
                    System.out.println("Asientos Ocupados: " + asientosOcupados);
                    // Cálculo dinámico de asientos libres
                    System.out.println("Asientos Libres: " + (25 - asientosOcupados)); 
                    System.out.println("Recaudación Total: $" + recaudacionTotal);
                    break;

                case 0:
                    System.out.println("Cerrando el sistema del cine. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("❌ Opción no válida. Intente nuevamente.");
            }

        } while (opcion != 0);

        scan.close();
    }
}
