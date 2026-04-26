/**
 * Clase base Figura.
 */
class Figura {
    protected String color;

    public Figura(String color) {
        this.color = color;
    }

    public double calcularArea() {
        return 0;
    }
}

class Circulo extends Figura {
    private double radio;

    public Circulo(String color, double radio) {
        super(color);
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(radio, 2);
    }
}

class Rectangulo extends Figura {
    private double base;
    private double altura;

    public Rectangulo(String color, double base, double altura) {
        super(color);
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }
}

public class MainFiguras {
    public static void main(String[] args) {
        Figura c = new Circulo("Rojo", 5.0);
        Figura r = new Rectangulo("Azul", 4, 3);

        System.out.printf("Círculo %s - Área: %.2f\n", "Rojo", c.calcularArea());
        System.out.printf("Rectángulo %s - Área: %.2f\n", "Azul", r.calcularArea());
    }
}
