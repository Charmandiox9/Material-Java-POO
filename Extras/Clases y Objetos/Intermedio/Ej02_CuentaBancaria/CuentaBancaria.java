/**
 * Clase que simula una Cuenta Bancaria.
 */
public class CuentaBancaria {
    
    private String titular;
    private double saldo;

    public CuentaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        if (saldoInicial >= 0) {
            this.saldo = saldoInicial;
        } else {
            this.saldo = 0;
        }
    }

    /**
     * Incrementa el saldo de la cuenta.
     */
    public void depositar(double monto) {
        if (monto > 0) {
            this.saldo += monto;
            System.out.println("Depósito exitoso. Nuevo saldo: $" + this.saldo);
        }
    }

    /**
     * Reduce el saldo si hay fondos suficientes.
     */
    public void retirar(double monto) {
        if (monto > 0 && monto <= this.saldo) {
            this.saldo -= monto;
            System.out.println("Retiro exitoso. Nuevo saldo: $" + this.saldo);
        } else {
            System.out.println("Error: Fondos insuficientes para retirar $" + monto);
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria("Juan Pérez", 1000.0);
        
        cuenta.retirar(1200.0);
        cuenta.depositar(500.0);
        cuenta.retirar(300.0);
    }
}
