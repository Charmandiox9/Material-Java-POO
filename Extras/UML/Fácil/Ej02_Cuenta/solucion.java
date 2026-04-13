package Fácil.Ej02_Cuenta;

/**
 * Clase que representa a una cuenta bancaria con comportamiento modelado en UML.
 * Este ejercicio demuestra el modelado de métodos con parámetros y tipos de retorno.
 * 
 * @author Daniel Durán García
 * @version 1.0
 */
public class CuentaBancaria {
    // - numeroCuenta : String
    private String numeroCuenta;

    // - saldo : double
    private double saldo;

    /**
     * Constructor público para inicializar la cuenta bancaria.
     * @param numero El número de cuenta único.
     * @param saldoInicial El saldo inicial con el que se abre la cuenta.
     */
    public CuentaBancaria(String numero, double saldoInicial) {
        this.numeroCuenta = numero;
        this.saldo = (saldoInicial >= 0) ? saldoInicial : 0;
    }

    /**
     * Incrementa el saldo de la cuenta con un monto específico.
     * @param monto El valor a depositar.
     */
    public void depositar(double monto) {
        if (monto > 0) {
            this.saldo += monto;
        }
    }

    /**
     * Intenta retirar un monto del saldo disponible.
     * @param monto El valor a retirar de la cuenta.
     * @return true si la operación se realizó con éxito, false si el saldo fue insuficiente.
     */
    public boolean retirar(double monto) {
        if (monto > 0 && this.saldo >= monto) {
            this.saldo -= monto;
            return true;
        }
        return false;
    }

    /**
     * Obtiene el saldo actual de la cuenta bancaria.
     * @return El saldo total en formato double.
     */
    public double getSaldo() {
        return saldo;
    }
}
