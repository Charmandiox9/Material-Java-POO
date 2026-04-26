/**
 * Clase abstracta que define la base para cualquier método de pago.
 */
abstract class MetodoPago {
    public abstract void procesarPago(double monto);
}

class TarjetaCredito extends MetodoPago {
    @Override
    public void procesarPago(double monto) {
        double total = monto * 1.05; // 5% recargo
        System.out.println("Procesando tarjeta: $" + monto + " + $" + (monto*0.05) + " comisión. Total: $" + total);
    }
}

class Efectivo extends MetodoPago {
    @Override
    public void procesarPago(double monto) {
        double total = monto * 0.90; // 10% descuento
        System.out.println("Procesando efectivo: $" + monto + " - $" + (monto*0.10) + " descuento. Total: $" + total);
    }
}

public class MainPagos {
    public static void main(String[] args) {
        MetodoPago p1 = new TarjetaCredito();
        MetodoPago p2 = new Efectivo();

        p1.procesarPago(1000);
        p2.procesarPago(1000);
    }
}
