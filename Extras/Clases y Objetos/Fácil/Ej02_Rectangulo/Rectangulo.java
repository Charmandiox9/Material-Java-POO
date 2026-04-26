/**
 * Clase Rectangulo para cálculos geométricos.
 */
public class Rectangulo {
    
    private double base;
    private double altura;

    /**
     * Constructor para inicializar el rectángulo.
     * @param base   Largo de la base.
     * @param altura Largo de la altura.
     */
    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    /**
     * Calcula el área del rectángulo.
     * @return double área calculada.
     */
    public double calcularArea() {
        return base * altura;
    }

    /**
     * Calcula el perímetro del rectángulo.
     * @return double perímetro calculado.
     */
    public double calcularPerimetro() {
        return 2 * (base + altura);
    }

    public static void main(String[] args) {
        // Instanciamos el objeto con valores de prueba
        Rectangulo r1 = new Rectangulo(10.5, 5.0);
        
        System.out.println("--- Dimensiones del Terreno ---");
        System.out.println("Área: " + r1.calcularArea() + " m²");
        System.out.println("Perímetro: " + r1.calcularPerimetro() + " m");
    }
}
