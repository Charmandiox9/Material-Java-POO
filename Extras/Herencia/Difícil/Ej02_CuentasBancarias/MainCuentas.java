/**
 * Clase abstracta Cuenta.
 */
abstract class Cuenta {
    protected String titular;
    protected double saldo;

    public Cuenta(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public abstract void retirar(double monto);
}

class CuentaAhorro extends Cuenta {
    private double tasaInteres;

    public CuentaAhorro(String titular, double saldo, double tasa) {
        super(titular, saldo);
        this.tasaInteres = tasa;
    }

    public void aplicarInteres() {
        saldo += saldo * (tasaInteres / 100);
    }

    @Override
    public void retirar(double monto) {
        if (monto <= saldo) {
            saldo -= monto;
        } else {
            System.out.println("Error: No puede retirar más de su saldo en cuenta ahorro.");
        }
    }

    public double getSaldo() { return saldo; }
}

class CuentaCorriente extends Cuenta {
    private double limiteSobregiro;

    public CuentaCorriente(String titular, double saldo, double limite) {
        super(titular, saldo);
        this.limiteSobregiro = limite;
    }

    @Override
    public void retirar(double monto) {
        if (saldo - monto >= -limiteSobregiro) {
            saldo -= monto;
            System.out.println("Retiro exitoso. Saldo actual: $" + saldo);
        } else {
            System.out.println("Error: Supera el límite de sobregiro.");
        }
    }
}

public class MainCuentas {
    public static void main(String[] args) {
        CuentaAhorro ca = new CuentaAhorro("Ana", 1000, 5);
        ca.aplicarInteres();
        System.out.println("Saldo Ahorro: $" + ca.getSaldo());

        CuentaCorriente cc = new CuentaCorriente("Luis", 500, 200);
        cc.retirar(600);
    }
}
