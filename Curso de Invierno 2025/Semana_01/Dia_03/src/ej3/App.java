package ej3;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class App {
    static ArrayList<Estudiante> estudiantes = new ArrayList<>();
    
    public static void leerArchivo() throws FileNotFoundException {
    	String archivo = "estudiantes.csv";
        System.out.println("Cargando datos desde " + archivo + "...");
        
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            boolean esPrimeraLinea = true;
            
            while ((linea = br.readLine()) != null) {
                if (esPrimeraLinea) {
                    esPrimeraLinea = false;
                    continue;
                }
                
                String[] datos = linea.split(",");
                
                if (datos.length == 5) {
                    String codigo = datos[0].trim();
                    String nombre = datos[1].trim();
                    int edad = Integer.parseInt(datos[2].trim());
                    String carrera = datos[3].trim();
                    double promedio = Double.parseDouble(datos[4].trim());
                    
                    Estudiante estudiante = new Estudiante(codigo, nombre, edad, carrera, promedio);
                    estudiantes.add(estudiante);
                }
            }
            
            System.out.println("Datos cargados exitosamente!");
            System.out.println("Total de estudiantes: " + estudiantes.size());
            
            mostrarMenu();
            
        } catch (FileNotFoundException e) {
            System.out.println("❌ No se encontró el archivo " + archivo);
        } catch (IOException e) {
            System.out.println("❌ Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("❌ Error en el formato de los datos: " + e.getMessage());
        }
    }
    
    public static void mostrarMenu() {
        int opcion;
        Scanner scan = new Scanner(System.in);
        
        do {
            System.out.println("\n----GESTIÓN DE ESTUDIANTES----");
            System.out.println("1. Mostrar todos los estudiantes");
            System.out.println("2. Buscar por nombre");
            System.out.println("3. Filtrar por carrera");
            System.out.println("4. Estudiantes con mejor promedio");
            System.out.println("5. Resumen de datos");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            
            opcion = scan.nextInt();
            scan.nextLine();
            
            switch(opcion) {
                case 1:
                    System.out.println("\n---MOSTRAR TODOS LOS ESTUDIANTES---");
                    if (estudiantes.isEmpty()) {
                        System.out.println("No hay estudiantes registrados.");
                    } else {
                        for(Estudiante e: estudiantes) {
                            System.out.println(e);
                        }
                    }
                    break;
                    
                case 2:
                    System.out.println("\n---BUSCAR POR NOMBRE---");
                    System.out.print("Indica el nombre a buscar: ");
                    String nombre = scan.nextLine();
                    boolean encontrado = false;
                    
                    for(Estudiante e: estudiantes) {
                        if(e.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                            System.out.println(e);
                            encontrado = true;
                        }
                    }
                    
                    if (!encontrado) {
                        System.out.println("No se encontró ningún estudiante con ese nombre.");
                    }
                    break;
                    
                case 3:
                    System.out.println("\n---FILTRAR POR CARRERA---");
                    System.out.print("Indica la carrera a filtrar: ");
                    String carrera = scan.nextLine();
                    boolean hayEstudiantes = false;
                    
                    for(Estudiante e: estudiantes) {
                        if(e.getCarrera().toLowerCase().contains(carrera.toLowerCase())) {
                            System.out.println(e);
                            hayEstudiantes = true;
                        }
                    }
                    
                    if (!hayEstudiantes) {
                        System.out.println("No se encontraron estudiantes en esa carrera.");
                    }
                    break;
                    
                case 4:
                    if (estudiantes.isEmpty()) {
                        System.out.println("No hay datos para mostrar.");
                        break;
                    }
                    
                    System.out.println("\n---TOP 5 MEJORES PROMEDIOS---");
                    ArrayList<Estudiante> ordenados = new ArrayList<>(estudiantes);
                    ordenados.sort((e1, e2) -> Double.compare(e2.getPromedio(), e1.getPromedio()));
                    
                    int limite = Math.min(5, ordenados.size());
                    
                    for(int i = 0; i < limite; i++) {
                        System.out.println((i+1) + ". " + ordenados.get(i));
                    }
                    break;
                    
                case 5:
                    if (estudiantes.isEmpty()) {
                        System.out.println("No hay datos para mostrar.");
                        break;
                    }
                    
                    double sumaPromedios = 0.0;
                    int edadTotal = 0;
                    String nombreMejorPromedio = "";
                    double mejorPromedio = Double.MIN_VALUE;
                    String nombrePeorPromedio = "";
                    double peorPromedio = Double.MAX_VALUE;
                    
                    for (Estudiante est : estudiantes) {
                        sumaPromedios += est.getPromedio();
                        edadTotal += est.getEdad();
                        
                        if(est.getPromedio() > mejorPromedio) {
                            mejorPromedio = est.getPromedio();
                            nombreMejorPromedio = est.getNombre();
                        }
                        
                        if(est.getPromedio() < peorPromedio) {
                            peorPromedio = est.getPromedio();
                            nombrePeorPromedio = est.getNombre();
                        }
                    }
                    
                    System.out.println("\n--- RESUMEN DE DATOS ---");
                    System.out.println("Total de estudiantes: " + estudiantes.size());
                    System.out.printf("Promedio general: %.2f%n", (sumaPromedios/estudiantes.size()));
                    System.out.printf("Edad promedio: %.1f%n", ((double)edadTotal/estudiantes.size()));
                    System.out.println("Estudiante con mejor promedio: " + nombreMejorPromedio + " (" + mejorPromedio + ")");
                    System.out.println("Estudiante con peor promedio: " + nombrePeorPromedio + " (" + peorPromedio + ")");
                    break;
                    
                case 0:
                    System.out.println("Hasta luego :D");
                    break;
                    
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción del 0 al 5.");
                    break;
            }
            
        } while(opcion != 0);
        
        scan.close();
    }
    
    public static void main(String[] args) {
        try {
            leerArchivo();
        } catch (FileNotFoundException e) {
            System.err.println("Error: No se pudo encontrar el archivo estudiantes.csv");
            System.err.println("Asegúrate de que el archivo existe en el directorio del proyecto.");
        }
    }
}
