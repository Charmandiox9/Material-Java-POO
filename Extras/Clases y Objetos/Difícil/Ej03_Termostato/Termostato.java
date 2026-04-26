/**
 * Clase que representa un Termostato con lógica de control.
 */
public class Termostato {
    
    private double temperaturaActual;
    private double temperaturaObjetivo;
    private String modo; // "CALOR", "FRIO", "OFF"

    public Termostato(double tempInicial) {
        this.temperaturaActual = tempInicial;
        this.temperaturaObjetivo = 22.0; // Valor por defecto
        this.modo = "OFF";
    }

    public void setObjetivo(double temp) {
        this.temperaturaObjetivo = temp;
    }

    /**
     * Simula la lectura de un sensor.
     */
    public void leerSensor(double nuevaTemp) {
        this.temperaturaActual = nuevaTemp;
    }

    /**
     * Decide qué acción tomar.
     */
    public void ejecutar() {
        System.out.println("--- Estado del Termostato ---");
        System.out.println("Actual: " + temperaturaActual + "°C | Objetivo: " + temperaturaObjetivo + "°C");
        
        if (temperaturaActual < temperaturaObjetivo - 1) {
            modo = "CALOR";
            System.out.println("Acción: ENCENDIENDO CALEFACCIÓN");
        } else if (temperaturaActual > temperaturaObjetivo + 1) {
            modo = "FRIO";
            System.out.println("Acción: ENCENDIENDO AIRE ACONDICIONADO");
        } else {
            modo = "OFF";
            System.out.println("Acción: SISTEMA EN ESPERA (Temperatura estable)");
        }
    }

    public static void main(String[] args) {
        Termostato t = new Termostato(25.0);
        t.setObjetivo(20.0);
        t.ejecutar();
        
        System.out.println();
        t.leerSensor(18.0);
        t.ejecutar();
    }
}
