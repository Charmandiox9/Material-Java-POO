/**
 * Clase base Empleado.
 */
class Empleado {
    protected String nombre;
    protected double salarioBase;

    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salarioBase = salario;
    }

    public double calcularSalario() {
        return salarioBase;
    }
}

/**
 * Subclase Vendedor.
 */
class Vendedor extends Empleado {
    private double comision;

    public Vendedor(String nombre, double salario, double comision) {
        super(nombre, salario);
        this.comision = comision;
    }

    @Override
    public double calcularSalario() {
        return salarioBase + comision;
    }
}

/**
 * Subclase Repartidor.
 */
class Repartidor extends Empleado {
    private int edad;

    public Repartidor(String nombre, double salario, int edad) {
        super(nombre, salario);
        this.edad = edad;
    }

    @Override
    public double calcularSalario() {
        // Bono de 100 si es menor de 25 años
        if (edad < 25) {
            return salarioBase + 100;
        }
        return salarioBase;
    }
}

public class MainNomina {
    public static void main(String[] args) {
        Empleado v = new Vendedor("Carlos", 1000, 200);
        Empleado r = new Repartidor("Dani", 1000, 22);

        System.out.println("Salario de " + v.nombre + ": $" + v.calcularSalario());
        System.out.println("Salario de " + r.nombre + ": $" + r.calcularSalario());
    }
}
