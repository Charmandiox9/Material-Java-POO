package Fácil.Ej02_Conversor;

import java.util.Scanner;

/**
 * Clase principal que resuelve el ejercicio de Conversor de Divisas.
 * Se utiliza un menú interactivo con do-while y switch-case.
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
        int opcion = 0;

        // Definición de tasas de cambio fijas (uso de constantes conceptuales)
        double tasaUSD = 850.0;
        double tasaEUR = 920.0;

        // El ciclo do-while garantiza que el menú se muestre al menos una vez
        do {
            System.out.println("\n=== CONVERSOR DE DIVISAS ===");
            System.out.println("1. Convertir CLP a Dólar (USD)");
            System.out.println("2. Convertir CLP a Euro (EUR)");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = scan.nextInt();

            // Selección de la lógica basada en la opción del usuario
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese monto en CLP: ");
                    double montoUSD = scan.nextDouble();
                    double resultadoUSD = montoUSD / tasaUSD;
                    System.out.println("Resultado: " + String.format("%.2f", resultadoUSD) + " USD");
                    break;
                
                case 2:
                    System.out.print("Ingrese monto en CLP: ");
                    double montoEUR = scan.nextDouble();
                    double resultadoEUR = montoEUR / tasaEUR;
                    System.out.println("Resultado: " + String.format("%.2f", resultadoEUR) + " EUR");
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }

        } while (opcion != 0); // La condición de salida es que la opción sea 0

        scan.close();
    }
}
