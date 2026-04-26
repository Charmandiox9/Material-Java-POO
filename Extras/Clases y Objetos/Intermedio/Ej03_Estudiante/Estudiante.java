/**
 * Clase Estudiante para gestión de notas.
 */
public class Estudiante {
    
    private String nombre;
    private String matricula;
    private double nota1;
    private double nota2;
    private double nota3;

    public Estudiante(String nombre, String matricula, double n1, double n2, double n3) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.nota1 = n1;
        this.nota2 = n2;
        this.nota3 = n3;
    }

    /**
     * Calcula el promedio simple de las tres notas.
     */
    public double calcularPromedio() {
        return (nota1 + nota2 + nota3) / 3.0;
    }

    /**
     * Determina si el estudiante aprobó.
     */
    public String obtenerEstado() {
        return (calcularPromedio() >= 4.0) ? "APROBADO" : "REPROBADO";
    }

    public void mostrarReporte() {
        System.out.println("Estudiante: " + nombre + " (ID: " + matricula + ")");
        System.out.printf("Promedio: %.1f\n", calcularPromedio());
        System.out.println("Estado: " + obtenerEstado());
    }

    public static void main(String[] args) {
        Estudiante est = new Estudiante("Sofía", "2024-001", 5.5, 3.8, 6.0);
        est.mostrarReporte();
    }
}
