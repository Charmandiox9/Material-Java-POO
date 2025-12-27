package ej3;

public class Estudiante {
	private String codigo;
    private String nombre;
    private int edad;
    private String carrera;
    private double promedio;
    
    public Estudiante(String codigo, String nombre, int edad, String carrera, double promedio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.edad = edad;
        this.carrera = carrera;
        this.promedio = promedio;
    }
    
    // Getters
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getCarrera() { return carrera; }
    public double getPromedio() { return promedio; }
    
    @Override
    public String toString() {
        return String.format("%s - %s (%d años) - %s - Promedio: %.1f", 
                codigo, nombre, edad, carrera, promedio);
    }
}
